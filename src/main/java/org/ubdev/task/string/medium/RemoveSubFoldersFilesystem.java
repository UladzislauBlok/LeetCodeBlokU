package org.ubdev.task.string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoveSubFoldersFilesystem {

    public List<String> removeSubfoldersSort(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]); // first
        for (int i = 1; i < n; i++) {
            String prev = res.getLast();
            String curr = folder[i];
            if (prev.length() >= curr.length()||
                    !curr.startsWith(prev) ||
                    curr.charAt(prev.length()) != '/') {
                res.add(curr);
            }
        }
        return res;
    }

    // Without sorting
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Set<String> fset = new HashSet<>();
        Collections.addAll(fset, folder);
        for(String f : folder){
            res.add(f);
            for(int i=0; i< f.length(); i++){
                if(f.charAt(i)== '/' && fset.contains(f.substring(0,i))){
                    res.removeLast();
                    break;
                }
            }
        }
        return res;
    }

    private static class TrieNode {

        boolean isEndOfFolder;
        HashMap<String, TrieNode> children;

        TrieNode() {
            this.isEndOfFolder = false;
            this.children = new HashMap<>();
        }
    }

    TrieNode root = new TrieNode();

    public List<String> removeSubfoldersTrie(String[] folder) {
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
            for (String folderName : folderNames) {
                if (folderName.isEmpty()) continue;
                if (!currentNode.children.containsKey(folderName)) {
                    currentNode.children.put(folderName, new TrieNode());
                }
                currentNode = currentNode.children.get(folderName);
            }
            currentNode.isEndOfFolder = true;
        }

        List<String> result = new ArrayList<>();
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
            boolean isSubfolder = false;
            for (int i = 0; i < folderNames.length; i++) {
                if (folderNames[i].isEmpty()) continue;
                TrieNode nextNode = currentNode.children.get(folderNames[i]);
                if (nextNode.isEndOfFolder && i != folderNames.length - 1) {
                    isSubfolder = true;
                    break;
                }
                currentNode = nextNode;
            }
            if (!isSubfolder) result.add(path);
        }
        return result;
    }
}
