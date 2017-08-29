package com.sundaydevblog.contactbook;

/**
 * {@link Contact} represents a contact information about person.
 * Each object has 4 properties: name, address, mobile number and image resource ID.
 */

public class Contact {
    private String mContactName;
    private String mContactAddress;
    private String mContactMobile;
    private int mContactImageResourceId;

    /**
     * Create a new Contact object
     *
     * @param mContactName            is the name of contact person
     * @param mContactAddress         is the address of contact person
     * @param mContactMobile          is the mobile number of contact person
     * @param mContactImageResourceId is drawable reference ID that corresponds to the contact person
     */
    public Contact(String mContactName, String mContactAddress, String mContactMobile, int mContactImageResourceId) {
        this.mContactName = mContactName;
        this.mContactAddress = mContactAddress;
        this.mContactMobile = mContactMobile;
        this.mContactImageResourceId = mContactImageResourceId;
    }

    // Getters
    public String getContactName() {
        return mContactName;
    }

    public String getContactAddress() {
        return mContactAddress;
    }

    public String getContactMobile() {
        return mContactMobile;
    }

    public int getContactImageResourceId() {
        return mContactImageResourceId;
    }
}
