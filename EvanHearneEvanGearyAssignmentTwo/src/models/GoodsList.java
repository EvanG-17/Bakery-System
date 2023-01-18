package models;

// Evan Geary (20098723) - Applied Computing (Computer Forensics and Security), Data Structures and Algorithms.

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class GoodsList<F> implements Serializable{
    public GoodsNode<F> head = null;

    public GoodsNode<F> getHead() {
        return head;
    }

    public void setHead(GoodsNode<F> head) {
        this.head = head;
    }

    public void addElement(F e) { //Add element to head of list
        GoodsNode<F> fn = new GoodsNode<>();
        fn.setContents(e);
        fn.next=head;
        head=fn;
    }

    //Add other insertion, deletion, access, search, etc. methods too

    //Reset System Method - Makes starting head null which wipes linked list.

    public void resetSystem() { //Empty's List
        head=null;
    }

    //Delete method for Linked List. -- Learning Center Help.
    public void delete(int d) {
        GoodsNode<F> temp = head;
        int i = 1;

        while (i < d && temp != null) {         // While is Less than D and temp is not equal null
            temp = temp.next;                   //Sets temp to next node in list
            i++;
        }

        if (d == 0) {
            head = head.next;
        }
        else if (temp !=null && temp.next != null){  //Node before deleted node skips deleted node.
            temp.next = temp.next.next;              //Creates path to node after deleted node.
        }
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "head=" + head +
                '}';
    }

    //Inner class approach.
    public class GoodsNode<F> implements Serializable{
        public GoodsNode<F> next=null;
        private F contents; //ADT reference!

        public F getContents() { return contents; }

        public void setContents(F c) { contents=c; }
    }

    // This method loads a previously serialised file into the system, reading it as the 'head' of the linked list.
    public void load(String filename) throws Exception {
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //read the object
        setHead((GoodsNode<F>) ois.readObject());
    }

    // This method serialises the entire linked list collection, saving it to a file.
    public void save(String filename) throws Exception {
        File file = new File( filename) ;
        FileOutputStream fileOutputStream = new FileOutputStream(file) ;
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        //storing the object
        oos.writeObject(getHead());
    }

    // This method converts the GoodsList into a List.
    public ObservableList<F> listGoodNodes() {
        ObservableList<F> a = FXCollections.observableArrayList();
        GoodsNode<F> temp = head;
        while (temp != null) {
            a.add(temp.getContents());
            temp = temp.next;
        }
        return a;
    }

//    public void search(F data) {
//        GoodsNode<F> current = head;
//        while (current != null) {
//            if (current.data.equals(data)) {
//                .getItems().add(String.valueOf(tempJT));
//            }
//            current = current.next;
//        }
//        return false;
//    }


}