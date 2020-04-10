package ques1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {

    Folder currentFolder;
    List<String> folders = new ArrayList<String>();

    public Command() {
        super();
        this.currentFolder = new Folder("R");
    }

    public void commandPrompt() {
        System.out.println(":: Welcome to Virtual Command Prompt ::");
        String commands;
        Scanner input = new Scanner(System.in);
        while (true) {
            showPath();
            commands = input.nextLine();
            String commandArray[] = commands.split(" ");
            Integer commandLength = commandArray.length;
            if (commandLength == 2) {
                switch (commandArray[0]) {

                    case "mkdir":
                        if (mkdir(commandArray[1]))
                            System.out.println("New Folder Created.");
                        else
                            System.out.println("Folder already exit.");
                        break;

                    case "cd":
                        if (!cd(commandArray[1]))
                            System.out.println("Folder is not exists");
                        break;

                    case "find":
                        String path = find(commandArray[1]);
                        System.out.println(path);
                        break;

                    default:
                        System.out.println("No Command found");
                        break;
                }
            }
            else if (commandLength == 1) {
                switch (commandArray[0]) {

                    case "bk":
                        if (!bk())
                            System.out.println("This is root directory");
                        break;

                    case "ls":
                        ls();
                        break;

                    case "tree":
                        tree();
                        break;
                    case "exit":
                        input.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Command Not found");

                }
            }
            else{
                System.out.println("Invalid Command");
               
            }
        }

    }

    private void showPath() {
        System.out.print("R:");
        for (String folderName : this.folders) {
            System.out.print("\\" + folderName);
        }
        System.out.print(">");
    }

    private boolean mkdir(String folderName) {
        if (findfolder(folderName)) {
            Folder newFolder = new Folder(folderName);
            newFolder.setParent(this.currentFolder);
            this.currentFolder.subfolder.add(newFolder);

            return true;
        } else
            return false;
    }

    private boolean findfolder(String folderName) {
        List<Folder> subFolders = this.currentFolder.getSubfolder();
        for (Folder currentFolders : subFolders) {
            if (currentFolders.getFolderName().equals(folderName))
                return false;
        }
        return true;
    }

    private boolean cd(String folderName) {
        if (!findfolder(folderName)) {
            List<Folder> subFolders = this.currentFolder.getSubfolder();
            for (Folder currentFolders : subFolders) {
                if (currentFolders.getFolderName().equals(folderName)) {
                    this.currentFolder = currentFolders;
                    folders.add(this.currentFolder.getFolderName());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bk() {
        Folder parent = this.currentFolder.getParent();
        if (parent == null)
            return false;
        this.currentFolder = parent;
        this.folders.remove(this.folders.size() - 1);
        return true;
    }

    private boolean ls() {
        List<Folder> subFolders = this.currentFolder.getSubfolder();
        for (Folder folder : subFolders) {
            showFolderDetail(folder);
        }
        System.out.println(subFolders.size()+" Folder(s) found");
        return true;
    }

    private void showFolderDetail(Folder folder) {
        System.out.println(folder.getFolderName() + "  " + folder.getDatetime());
    }

    private String find(String folderName) {
        return search(this.currentFolder, folderName);
    }

    private String search(Folder folder, String folderName) {
        if (folder.getFolderName().equals(folderName))
            return folderName;
        if (folder.getSubfolder().size() < 1)
            return "";
        String path = "";
        for (Folder subfold : folder.getSubfolder()) {
            path = "";
            path = path + folder.getFolderName() + "/" + search(subfold, folderName);
        }

        return path;
    }

    public void tree() {
        showTree(this.currentFolder, 0);
    }

    /**
     * method to display the tree of the given directory
     * 
     * @param folder which is current directory
     * @param nesting is the level of the sub folder
     */
    private void showTree(Folder folder, Integer nesting) {

        for (Folder subDirectory : folder.getSubfolder()) {
            for (int i = 0; i < nesting; i++)
                System.out.print("|   ");
            if (subDirectory.getSubfolder().size() != 0) {
                System.out.println("|---" + subDirectory.getFolderName());
                showTree(subDirectory, nesting + 1);
            } else
                System.out.println("|___" + subDirectory.getFolderName());
        }

    }
}
