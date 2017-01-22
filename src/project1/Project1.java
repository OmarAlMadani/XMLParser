
package project1;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Project1 {

    public static void main(String[] args) throws IOException {
        Parser p = new Parser("G:/students.xml");
        p.parseFile();
        
      }
}

class Node1<T>{
    public T data;
    public Node1<T> next;
    public Node1(){
        data=null;
       
    }
    public Node1(T val){
        data=val;
        next=null;
    }
}

class ArrayList<T>{
    public int maxSize;
    public int size;
    public int current;
    public Node1<T> nodes[];
    
    public ArrayList(int n){
        maxSize=n;
        size=0;
        current=-1;
        nodes= new Node1[n];
    }
    public boolean empty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean last(){
        if(current==maxSize){
            return true;
        }
        else{
            return false;
        }
            
        }
    public boolean full(){
        if(size==maxSize){
            return true;
        }
        else{
        return false;
        }
    }
    public void findFirst(){
        if(!empty()){
            current=0;
        }
    }
    public void findNext(){
        if((!empty()) && (current!=maxSize)){
            current++;
        }
    }
    public T retrive(){
        T e=null;
        if(!empty())
            e=nodes[current].data;
        return e;
    }
    public void update(T val){
            if(!empty()){
                nodes[current].data=val;
            }
    }
    public void insert(T val){
        Node1<T> nn=new Node1<T>(val);
        if(full()) {
          System.out.println("The Array Is Full");
        }
        else{
          for(int i=size-1;i>current;i--){
              nodes[i+1]=nodes[i];
          }
          current++;
          nodes[current]=nn;
          size++;
        }
    }
    public void remove(){
        if(!empty()){
            
             for(int i=current;i<size;i++){
                        nodes[i]=nodes[i+1];
                    }
                    size--;
                    if(size==0){
                        current=-1;
                    }else if(current==size){
                        current=0;
                    }
            }
           
        else
        {
            System.out.println("The Array Is Empty");
        }
    }
    public int length(){
         return size;
    }
    public int findItem(T val){
        if(!empty()){
            for(int i=0;i<size;i++){
                if(nodes[i].data==val){
                    return i;
                }    
            }
        }
        return -1;
    }
    public void printArray(){
        if(!empty()){
            for(int i=0;i<size;i++){
                    System.out.println("Node"+(i+1)+":"+nodes[i].data);
            
            }
            System.out.println("_____________________________________________");
        }
        else{
        System.out.println("Array Is Empty");
        }
    }
}

class LinkedList<T> {
    Node1<T> head;
    Node1<T> current;
    
    public LinkedList(){
        head=current=null;
    }
    public boolean empty(){
        if(head==null){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean last(){
        if(current.next==null){
            return true;}
        else{
            return false;
        }
            
        }
    public boolean full(){
        return false;
    }
    public void findFirst(){
        if(!empty()){
            current=head;
        }
    }
    public void findNext(){
        if(!empty() && current.next!=null){
            current=current.next;
        }
    }
    public T retrive(){
        T e=null;
        if(!empty())
            e= current.data;
        return e;
    }
    public void update(T val){
            if(!empty()){
                current.data=val;
            }
    }
    public void insert(T val){
        Node1<T> nn=new Node1<T>(val);
        Node1<T> temp;
      if(empty()) {
          head=current=nn;
      }
      else{
          temp=current.next;
          current.next=nn;
          current=current.next;
          current.next=temp;
      }
    }
    public void remove(){
        if(!empty()){
            Node1<T> prev=head;
            if(head==current){
                head=null;
            }
            else{
                while(prev.next!=current){
                    prev=prev.next;
                }
                prev.next=current.next;
                          
                    if(prev.next==null){
                        current=head;
                    }
                    else{
                        current=prev.next;
                    }
             }
          }           
      }
    public int length(){
        
        int counter=1;
        if(!empty()){
            if(head.next==null){
                return counter;
            }
            else
            {
                Node1<T> pointer=head;
                while(pointer.next!=null){
                    counter++;
                    pointer=pointer.next;
                }
                return counter;
            }
        }
        else{
        return 0;
        }
    }    
    public boolean findItem(T val){
        if(!empty()){
         if(head.data==val){
                return true;
            }
            else
            {
                Node1<T> pointer=head;
                boolean found=false;
                while((pointer.next!=null)&& !found){
                    if(pointer.data==val){
                        found=true;
                    }
                    else{
                    pointer=pointer.next;
                    }
                }
                return found;
            }   
            
        }
        else{
        return false;
        }
    }
    public void printList(){
        int counter=1;
        if(!empty()){
            if(head.next==null){
                System.out.println("Node"+counter+":"+head.data);
            }
            else
            {
                Node1<T> pointer=head;
                while(pointer!=null){
                    System.out.println("Node"+counter+":"+pointer.data);
                    counter++;
                    pointer=pointer.next;
                }
                
            }
        }
        else{
        System.out.println("List Is Empty");
        }
    }
}

class Field {
    private String fName;
    private String fData;
    
    public Field(String fn,String fd){
        fName=fn;
        fData=fd;
    }
    public void setName(String fn){
        fName=fn;
    }
    public String getName(){
        return fName;
    }
    public void setData(String fd){
        fData=fd;
    }
    public String getData(){
        return fData;
    }
    public void display(){
        System.out.println(fName+":"+fData);
    }
}

class Record{
    private ArrayList<Field> fields;
    
    public ArrayList<Field> getFields(){
    return fields;
    }
    public Record(int maxSize){
        fields=new ArrayList<Field>(maxSize);
    }
    public void addField(Field nf){
        fields.insert(nf);
    }
    public void display(){
        Field e ;
        fields.findFirst();  
        for(int i=0;i<fields.size;i++){
         e= fields.retrive();
         e.display();
         fields.findNext();
        }
    }
}

class Table{
private LinkedList<Record> records;


public LinkedList<Record> getRecords(){
    return records;
}
public Table(){
records=new LinkedList<Record>();    
}
public void addRecord(Record nr){
    records.insert(nr);
}
    public void display(){
        Record e ;
        records.findFirst();  
        System.out.println("__________________________");
        while(records.current.next!=null){
         e= records.retrive();
         e.display();
         records.findNext();
         System.out.println("__________________________");
        }
        e=records.retrive();
        e.display();
        System.out.println("__________________________");
    }
}
class Parser{
 private String dataBaseName;
 public Parser(String dbn){
     dataBaseName=dbn;
 }
 public void parseFile(){
   try{
        File f=new File(dataBaseName);
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        DocumentBuilder db= dbf.newDocumentBuilder();
        Document doc=db.parse(f);
        doc.getDocumentElement().normalize();
        System.out.println("The Root:"+doc.getDocumentElement().getNodeName());
        NodeList nl=doc.getElementsByTagName("student");
        System.out.println("The Number of elements:"+nl.getLength());
        System.out.println();
        Field fid,fname,fage;
        Record rstudent;
        Table table=new Table();
        for(int i=0;i<nl.getLength();i++){
            Element elm= (Element)nl.item(i);
            
            NodeList nlid=elm.getElementsByTagName("id");
            Element elmid=(Element)nlid.item(0);
            fid=new Field("id",elmid.getFirstChild().getNodeValue());
            
            NodeList nlname=elm.getElementsByTagName("name");
            Element elmname=(Element)nlname.item(0);
            fname=new Field("name",elmname.getFirstChild().getNodeValue());
            
            NodeList nlage=elm.getElementsByTagName("age");
            Element elmage=(Element)nlage.item(0);
            fage=new Field("age",elmage.getFirstChild().getNodeValue());
            
            rstudent=new Record(3);
            rstudent.addField(fid);
            rstudent.addField(fname);
            rstudent.addField(fage);
            table.addRecord(rstudent);
           
        }
        table.display();
        
      }
     catch(Exception e){
          System.out.println("program error!!!");
          System.out.println(e.toString());
      }
       
 }
}