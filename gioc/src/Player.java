import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Player {
    private int x, y, width, height;
    private double velocityX, velocityY;
    private boolean left, right;
    private boolean onGround, wallSliding;

    private long lastDashTime;
    private long lastGroundTime;
    private long jumpBufferTime;

    // Parametri fisici
    private final double gravity = 0.8;
    private final double jumpForce = -14;
    private final double moveSpeed = 6;
    private final double dashSpeed = 28;
    private final int dashDuration = 400;

    private boolean touchingLeftWall, touchingRightWall;
    private Color color;
    private boolean arrowControls;

    private long dashStartTime;
    private boolean isDashing;

    public Player(int x, int y, Color color, boolean arrowControls) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.color = color;
        this.arrowControls = arrowControls;
    }

    public void update(ArrayList<Rectangle> platforms) {
        if (!isDashing) {
            if (left) velocityX = -moveSpeed;
            else if (right) velocityX = moveSpeed;
            else velocityX = 0;
        }

        velocityY += gravity;

        if (onGround) lastGroundTime = System.currentTimeMillis();

        if (jumpBufferTime > 0 && onGround) {
            doJump();
            jumpBufferTime = 0;
        }

        if (isDashing) {
            if (System.currentTimeMillis() - dashStartTime > dashDuration) {
                isDashing = false;
            }
        }

        x += velocityX;
        y += velocityY;

        if (y + height >= 768) {
            y = 768 - height;
            velocityY = 0;
            onGround = true;
        } else {
            onGround = false;
        }

        for (Rectangle r : platforms) {
            if (new Rectangle(x, y, width, height).intersects(r)) {
                if (y + height - velocityY <= r.y) {
                    y = r.y - height;
                    velocityY = 0;
                    onGround = true;
                }
            }
        }

        touchingLeftWall = (x <= 0);
        touchingRightWall = (x + width >= 1330);

        if (touchingLeftWall) {
            x = 0;
            if (!onGround && velocityY > 0) {
                wallSliding = true;
                velocityY = 2;
            }
        } else if (touchingRightWall) {
            x = 1330 - width;
            if (!onGround && velocityY > 0) {
                wallSliding = true;
                velocityY = 2;
            }
        } else {
            wallSliding = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        if (arrowControls) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> left = true;
                case KeyEvent.VK_RIGHT -> right = true;
                case KeyEvent.VK_UP -> {
                    if (onGround || System.currentTimeMillis() - lastGroundTime < 120) {
                        doJump();
                    } else if (wallSliding) {
                        doWallJump();
                    } else {
                        jumpBufferTime = System.currentTimeMillis();
                    }
                }
                case KeyEvent.VK_L -> startDash();
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A -> left = true;
                case KeyEvent.VK_D -> right = true;
                case KeyEvent.VK_W -> {
                    if (onGround || System.currentTimeMillis() - lastGroundTime < 120) {
                        doJump();
                    } else if (wallSliding) {
                        doWallJump();
                    } else {
                        jumpBufferTime = System.currentTimeMillis();
                    }
                }
                case KeyEvent.VK_Q -> startDash();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (arrowControls) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> left = false;
                case KeyEvent.VK_RIGHT -> right = false;
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A -> left = false;
                case KeyEvent.VK_D -> right = false;
            }
        }
    }

    private void doJump() {
        velocityY = jumpForce;
        onGround = false;
    }

    private void doWallJump() {
        velocityY = jumpForce;
        if (touchingLeftWall) velocityX = moveSpeed;
        else if (touchingRightWall) velocityX = -moveSpeed;
        wallSliding = false;
    }

    private void startDash() {
        if (System.currentTimeMillis() - lastDashTime > 1000) {
            lastDashTime = System.currentTimeMillis();
            dashStartTime = System.currentTimeMillis();
            isDashing = true;
            velocityX = (left ? -dashSpeed : right ? dashSpeed : dashSpeed);
            velocityY = 0;
        }
    }

    public Rectangle getHitbox() {
        return new Rectangle(x, y, width, height);
    }

    public void resolveCollision(Player other) {
        Rectangle hb = getHitbox();
        Rectangle hbOther = other.getHitbox();
        if (hb.intersects(hbOther)) {
            // Knockback molto più forte
            if (!onGround) {
                if (x < other.x) {
                    other.x += 40;       // spinta orizzontale maggiore
                    other.velocityY = -12; // spinta verticale maggiore
                } else {
                    other.x -= 40;
                    other.velocityY = -12;
                }
            }
            // Separazione base
            if (x < other.x) {
                x -= 10;
                other.x += 10;
            } else {
                x += 10;
                other.x -= 10;
            }
        }
    }

    // Getter per GamePanel
    public int getX() { return x; }
    public int getY() { return y; }

    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public String getState() {
        if (isDashing) return "Dash";
        if (wallSliding) return "WallSlide";
        if (!onGround && velocityY < 0) return "Jump";
        if (!onGround && velocityY > 0) return "Falling";
        if (left || right) return "Run";
        return "Normal";
    }
}
