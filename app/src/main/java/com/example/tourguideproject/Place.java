package com.example.tourguideproject;

public class Place {

    /**
     * String resource for the name of place
     */
    private String name;

    /**
     * String resource for the description of the place
     */
    private String description;

    /**
     * int resource for images of the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param name is the name of the place
     * @param description is a paragraph descriping the place
     */
    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Create a new Word object.
     *
     * @param name is the name of the place
     * @param description is a paragraph descriping the place
     * @param mImageResourceId is the resource ID for the image file associated with the place
     */
    public Place(String name, String description, int mImageResourceId) {
        this.name = name;
        this.description = description;
        this.mImageResourceId = mImageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
