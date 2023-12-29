package com.example.Carabity.carabity.service;

public class ProfilePicture {
        private String name ;
        private String extension ;
        private byte[] format ;
        public ProfilePicture(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getFormat() {
        return format;
    }

    public void setFormat(byte[] format) {
        this.format = format;
    }
}
