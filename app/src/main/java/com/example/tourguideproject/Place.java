package com.example.tourguideproject;

public class Place {

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * String resource for the name of place
     */
    private String name;
    /**
     * String resource for the description of the place
     */
    private String description;
    /**
     * String resource for the description of the place
     */
    private String contactInformation;
    /**
     * int resource for images of the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /**
     * String resource for photo description place
     */
    private String photoDescription;

    /**
     * Create a new Word object.
     *
     * @param name               is the name of the place
     * @param description        is a paragraph descriping the place
     * @param contactInformation string for contact information
     */
    public Place(String name, String description, String contactInformation) {
        this.name = name;
        this.description = description;
        this.contactInformation = contactInformation;
    }

    /**
     * Create a new Word object.
     *
     * @param name               is the name of the place
     * @param description        is a paragraph descriping the place
     * @param contactInformation string for contact information
     * @param mImageResourceId   is the resource ID for the image file associated with the place
     */
    public Place(String name, String description, String contactInformation, int mImageResourceId, String photoDescription) {
        this.name = name;
        this.description = description;
        this.contactInformation = contactInformation;
        this.mImageResourceId = mImageResourceId;
        this.photoDescription = photoDescription;
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

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
