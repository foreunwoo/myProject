import java.util.Scanner;

//***************************
//파일명: MyBinarySearchTreeTest
//작성자: 201814011 김은우
//작성일: 2020-04-28
//내용: [hw6_1] binary search tree
//***************************

public class MyBinarySearchTreeTest {
   public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         MyBinarySearchTree t = new MyBinarySearchTree();
         
         System.out.println("hw6_1: 김은우");
         while(true) {
             System.out.println("1:삽입  2:검색   4:전체조회  5:종료");
             int n = scanner.nextInt();
             scanner.nextLine();
             boolean s = true; // 성공 여부

             if(n==1) {
                s = t.add(scanner.nextLine());
                if(s==false) {
                   System.out.println("삽입 실패");
                } else {
                   System.out.println("삽입 성공");
                }

             } else if(n==2) {
                s = t.contains(scanner.nextLine());
                if(s==false) {
                   System.out.println("검색 실패");
                } else {
                   System.out.println("검색 성공");
                }

             } else if(n==4) {
                t.print(t.getRoot());
                System.out.println();
                System.out.println("저장된 아이디 수: "+t.size(t.getRoot()));
                
             } else if(n==5) {
                break;
             }
         }
         scanner.close();
   }
}

class MyBinarySearchTree {
   private Node root;
   private int size; // 트리에 저장된 노드 수

   public Node getRoot() {
         return root;
   }

   public void setRoot(Node root) {
       this.root = root;
   }

   public MyBinarySearchTree() {
      this.root = null;
   }

   // 탐색
    public boolean contains(String id){
       if (contains(root, id) == 0) {
          return false;
       }

       return true;
    }

    // 탐색
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

    // 삽입
    public boolean add(String id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return true;
        }
        
        if(contains(id)) { // 삽입 전 트리에 같은 노드가 있는지 탐색
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

    // 중위 순회
    private void inorder(Node t) {
        if(t.getLeft() != null) {
           inorder(t.getLeft());
        }
        if(t.getRight() != null) {
           inorder(t.getRight());
        }
     }

    public int size(Node node) { // 트리에 저장된 아이디 수(노드 수)를 리턴
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

    public void print(Node node) { // 트리에 저장된 아이디를 모두 출력
        if(node != null) {
           print(node.getLeft());
           System.out.print(node.getId() + " ");
          print(node.getRight());

        }
     }

      private class Node {
         private String id; // 노드 id값
         private Node left;  // 왼쪽 하위 노드
         private Node right; // 오른쪽 하위 노드

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