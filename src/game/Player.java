package game;

import city.cs.engine.*;

public class Player extends Walker {

    private static final Shape playerShape = new PolygonShape(-0.893f, -1.0f, 0.779f, -0.996f, 0.771f, 1.0f, 0.547f, 0.996f, -0.329f, 0.888f, -0.905f, 0.224f);
    private static BodyImage imageRight = new BodyImage("data/PlayerRight.png", 2.25f);
    private static BodyImage imageLeft = new BodyImage("data/PlayerLeft.png", 2.25f);
    private static BodyImage gifRight = new BodyImage("data/PlayerRight.gif", 2.25f);
    private static BodyImage gifLeft = new BodyImage("data/PlayerLeft.gif", 2.25f);
    private static BodyImage jumpRight = new BodyImage("data/PlayerJumpRight.png", 2.25f);
    private static BodyImage jumpLeft = new BodyImage("data/PlayerJumpLeft.png", 2.25f);
    private static BodyImage parachuteImage = new BodyImage("data/parachute.png", 2.25f);
    private boolean movedRight;
    private boolean canGlide;

    private int ammoLeft;
    private int lifes;
    private int portalsLeft;
    private static int persistentAmmoLeft;
    private static int persistentLifes;
    private static int persistentPortalsLeft;
    private boolean gliding;
    private boolean hasKey;

    public int getPersistentAmmoLeft() {
        return persistentAmmoLeft;
    }

    public void setPersistentAmmoLeft(int persistentAmmoLeft) {
        this.persistentAmmoLeft = persistentAmmoLeft;
    }

    public int getPersistentLifes() {
        return persistentLifes;
    }

    public void setPersistentLifes(int persistentLifes) {
        this.persistentLifes = persistentLifes;
    }

    public int getPersistentPortalsLeft() {
        return persistentPortalsLeft;
    }

    public void setPersistentPortalsLeft(int persistentPortalsLeft) {
        this.persistentPortalsLeft = persistentPortalsLeft;
    }

    public boolean HasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isMovedRight() {
        return movedRight;
    }

    public void setMovedRight(boolean movedRight) {
        this.movedRight = movedRight;
    }

    public static BodyImage getImageRight() {
        return imageRight;
    }

    public static BodyImage getImageLeft() {
        return imageLeft;
    }

    public static BodyImage getGifRight() {
        return gifRight;
    }

    public static BodyImage getGifLeft() {
        return gifLeft;
    }

    public static BodyImage getJumpRight() {
        return jumpRight;
    }

    public static BodyImage getJumpLeft() {
        return jumpLeft;
    }

    public static BodyImage getParachuteImage() {
        return parachuteImage;
    }

    public int getAmmoLeft() {
        return ammoLeft;
    }

    public int getLifes() {
        return lifes;
    }

    public int getPortalsLeft() {
        return portalsLeft;
    }

    public boolean isGliding() {
        return gliding;
    }

    public boolean isCanGlide() {
        return canGlide;
    }

    public void setCanGlide(boolean canGlide) {
        this.canGlide = canGlide;
    }

    public void decreaseLifes() {
        GameLevel world = (GameLevel) this.getWorld();
        if (lifes > 0){
            lifes = lifes - 1;
            this.setPosition(world.startPosition());
            System.out.println("Lifes left: " + lifes);
        } else {
            this.destroy();
            System.out.println("YOU LOST!");
        }
    }

    public void increaseAmmo(){
        ammoLeft++;
        System.out.println("SHOTS LEFT: " + ammoLeft);
    }

    public void decreaseAmmo(){
        ammoLeft--;
        System.out.println("SHOTS LEFT: " + ammoLeft);
    }
    public void increasePortalsLeft() {
        this.portalsLeft = portalsLeft + 1;
        System.out.println("portals remaining: " + portalsLeft);
    }

    public void decreasePortalsLeft() {
        this.portalsLeft = portalsLeft - 1;
    }

    public void setGliding(boolean gliding) {
        this.gliding = gliding;
    }

    public Player(GameLevel world) {
        super(world, playerShape);
        addImage(imageRight);
        movedRight = true;
        ammoLeft = 2;
        lifes = 3;
        portalsLeft = 0;
        gliding = false;
        canGlide = false;
    }

    public void changeImage(BodyImage image) {
        this.removeAllImages();
        this.addImage(image);
    }
//
//    public boolean isWalkingRight(){
//        if(this.getLinearVelocity().x > 0){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isWalkingLeft(){
//        if(this.getLinearVelocity().x < 0){
//            return true;
//        }
//        return false;
//    }

    public boolean isJumping() {
        if (this.getLinearVelocity().y != 0) {
            return true;
        }
        return false;
    }

    public void storeProperties() {
        persistentAmmoLeft = ammoLeft;
        persistentLifes = lifes;
        persistentPortalsLeft = portalsLeft;
    }

    public void loadProperties() {
        ammoLeft = persistentAmmoLeft;
        lifes = persistentLifes;
        portalsLeft = persistentPortalsLeft;
    }

    {
        this.setGravityScale(4);
    }

}
