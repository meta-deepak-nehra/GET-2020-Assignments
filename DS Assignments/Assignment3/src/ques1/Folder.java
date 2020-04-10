package ques1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Folder {

    String folderName;
    List<Folder> subfolder;
    Folder parent;
    Date datetime;

    public Folder(String folderName) {
        super();
        this.folderName = folderName;
        this.datetime = Calendar.getInstance().getTime();
        this.parent = null;
        this.subfolder = new LinkedList<Folder>();
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public List<Folder> getSubfolder() {
        return subfolder;
    }

    public void setSubfolder(List<Folder> subfolder) {
        this.subfolder = subfolder;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public String getDatetime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateAndTime = dateFormat.format(this.datetime);
        return dateAndTime;
    }

}