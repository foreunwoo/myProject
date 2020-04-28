import java.util.Scanner;

//***************************
//���ϸ�: MyBinarySearchTreeTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-04-28
//����: [hw6_1] binary search tree
//***************************

public class MyBinarySearchTreeTest {
   public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         MyBinarySearchTree t = new MyBinarySearchTree();
         
         System.out.println("hw6_1: ������");
         while(true) {
             System.out.println("1:����  2:�˻�   4:��ü��ȸ  5:����");
             int n = scanner.nextInt();
             scanner.nextLine();
             boolean s = true; // ���� ����

             if(n==1) {
                s = t.add(scanner.nextLine());
                if(s==false) {
                   System.out.println("���� ����");
                } else {
                   System.out.println("���� ����");
                }

             } else if(n==2) {
                s = t.contains(scanner.nextLine());
                if(s==false) {
                   System.out.println("�˻� ����");
                } else {
                   System.out.println("�˻� ����");
                }

             } else if(n==4) {
                t.print(t.getRoot());
                System.out.println();
                System.out.println("����� ���̵� ��: "+t.size(t.getRoot()));
                
             } else if(n==5) {
                break;
             }
         }
         scanner.close();
   }
}

class MyBinarySearchTree {
   private Node root;
   private int size; // Ʈ���� ����� ��� ��

   public Node getRoot() {
         return root;
   }

   public void setRoot(Node root) {
       this.root = root;
   }

   public MyBinarySearchTree() {
      this.root = null;
   }

   // Ž��
    public boolean contains(String id){
       if (contains(root, id) == 0) {
          return false;
       }

       return true;
    }

    // Ž��
    public int contains(Node node, String id){
        if (node.getId().equals(id)) {
           return 1;
        }

        if (node.getLeft() != null && node.getRight() != null) {
            return contains(node.getLeft(), id)+contains(node.getRight(), id);
         }
         else if (node.getLeft() != null && node.getRight() == null) {
            return contains(node.getLeft(), id);
         }
         else if (node.getLeft() == null && node.getRight() != null) {
            return contains(node.getRight(), id);
         }
         else {
            return 0;
         }
    }

    // ����
    public boolean add(String id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return true;
        }
        
        if(contains(id)) { // ���� �� Ʈ���� ���� ��尡 �ִ��� Ž��
            return false;
         }

        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if((current.getId()).compareTo(id) > 0){
                current = current.getLeft();
                if(current==null){
                    parent.setLeft(newNode);
                    return true;
                }
            }else{
                current = current.getRight();
                if(current==null){
                    parent.setRight(newNode);
                    return true;
                }
            }
         
        }
    }

    // ���� ��ȸ
    private void inorder(Node t) {
        if(t.getLeft() != null) {
           inorder(t.getLeft());
        }
        if(t.getRight() != null) {
           inorder(t.getRight());
        }
     }

    public int size(Node node) { // Ʈ���� ����� ���̵� ��(��� ��)�� ����
        if (node.getLeft() != null && node.getRight() != null) {
           return size=size(node.getLeft())+size(node.getRight()) + 1;
        }
        else if (node.getLeft() != null && node.getRight() == null) {
           return size=size(node.getLeft()) + 1;
        }
        else if (node.getLeft() == null && node.getRight() != null) {
           return size=size(node.getRight()) + 1;
        }
        else {
           return 1;
        }
     }

    public void print(Node node) { // Ʈ���� ����� ���̵� ��� ���
        if(node != null) {
           print(node.getLeft());
           System.out.print(node.getId() + " ");
          print(node.getRight());

        }
     }

      private class Node {
         private String id; // ��� id��
         private Node left;  // ���� ���� ���
         private Node right; // ������ ���� ���

         public Node(String id) {
            this.setId(id);
            setLeft(null);
            setRight(null);
         }

         public String getId() {
            return id;
         }
         public void setId(String id) {
            this.id = id;
         }
         public Node getLeft() {
            return left;
         }
         public void setLeft(Node left) {
            this.left = left;
         }
         public Node getRight() {
            return right;
         }
         public void setRight(Node right) {
            this.right = right;
         }

      }
}