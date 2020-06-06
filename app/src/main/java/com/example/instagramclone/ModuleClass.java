package com.example.instagramclone;
public class ModuleClass {
    int userProfilePic;
    String userName;
    int userUploadedItem;

    public int getUserProfilePic() {
        return userProfilePic;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserUploadedItem() {
        return userUploadedItem;
    }

    public ModuleClass(int userProfilePic, String userName, int userUploadedItem) {
        this.userProfilePic = userProfilePic;
        this.userName = userName;
        this.userUploadedItem = userUploadedItem;
    }
}
