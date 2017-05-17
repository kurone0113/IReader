package com.kurone.ireader.entity;

import java.io.File;

/**
 * File info JavaBean class.Created by Kurone on 2017/4/27.
 */

public class FileInfo {
    private File file;
    private String fileType;
    private String iconType;
    private boolean isSelect;

    public FileInfo(File file, String fileType, String iconType) {
        this.file = file;
        this.fileType = fileType;
        this.iconType = iconType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
