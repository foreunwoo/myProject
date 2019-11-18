package ss;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//���� ����ǥ���� ������ �ް�, �̸� ����ǥ������� �ٲ� ��, ���.
//---------------------------------------------------------------------------------------
class PostFixConverter { //����ǥ��� ��ȯ�ϱ�
   private String infix; //����ǥ��
   private Stack<Character> stack = new Stack<Character>(); //�����ڵ� �ִ� stack
   private List<String> postfix = new ArrayList<String>();  //����ǥ��

   public PostFixConverter(String expression) {
      infix = expression; //���� ��
      convertExpression();
   }

   private void convertExpression() { 
      StringBuilder temp = new StringBuilder();  //���ڸ� �ִ� ��Ʈ������

      for (int i = 0; i != infix.length(); ++i) {
         if (Character.isDigit(infix.charAt(i))) { //����ǥ���� ���� ������ i��°�� ���ڸ� temp�� append.
            temp.append(infix.charAt(i));

              while ((i + 1) != infix.length()
                  && (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.')) {
                 //�� ���� �Ű� �������ƴҶ�+�����Ű� ���ڰų� .(�Ҽ���)�϶� -->�Ҽ����� �Ǻ��ϱ� ���� 
               temp.append(infix.charAt(++i));    //temp�� �� ������ append
              }

            postfix.add(temp.toString());  //������ temp�� ����Ȱ� ��Ʈ������ �ٲ㼭 add
            temp.delete(0, temp.length()); //tmep ������ �� ����->temp�� ���� �Ѱ� �ְ� postfix�� ���� temp��� �ݺ�(�Ҽ����� ��� �ϳ��� ���� ����ɼ� �ֵ���)
         }

         else
            inputToStack(infix.charAt(i)); //����ǥ���� �������� ���ڰ� �Ƴ����, �����ڶ�� stack�� �ִ� �Լ�
      }
      clearStack(); //������ ���鼭 ���������ڵڿ� pop�ϸ鼭 push���ִ� �Լ�. postfix�ڿ� stack�� �̾���
   }

   private void inputToStack(char input) { //������ �ֱ�
      if (stack.isEmpty() || input == '(') //������ ����ų� (�� stack�� push
         stack.push(input);
      else {
         if (input == ')') { //�ݴ� ��ȣ )�� ���  
            while (!stack.peek().equals('(')) { //���� ������ (�϶����� �ݺ�
               postfix.add(stack.pop().toString()); // (�̸� stack���� pop�Ѱ� ��Ʈ������ �ٲ� postfix�� add
            }
            stack.pop(); //
         } else { // �ݴ� ��ȣ )�� �ƴѰ��
            if (stack.peek().equals('(')) //���� ��ȣ ( �� ������ stack�� push
               stack.push(input);
            else {  // )�� (�� �ƴѰ�� 
               while (!stack.isEmpty() && !stack.peek().equals('(')  //stack�� ����ְ�+stack�� (�� ����
                     && getPrecedenceInComing(input) <= getPrecedenceInStack(stack.peek())) { //+(���� �Ŀ��� ������ �켱����<=stack�� �켱����)
                  postfix.add(stack.pop().toString());  //�̹� �ִ� ������ �켱������ �� ���� �� stack�� pop�� �� ��Ʈ������ ��ȯ�� postfix�� add
               }
               stack.push(input); //���� ���� ������ �������� �켱������ �� ���� ��� stack�� ����.
            }
         }
      }
   }
//�켱����(return���ڱ� �������� ���� ����ϰ���) : +,- < *,/ < ^
   private int getPrecedenceInComing(char op) { //���� �����ڵ� �߿��� ��������
      if (op == '+' || op == '-')
         return 1;
      else if (op == '*' || op == '/')
         return 2;
      else if (op == '^')
         return 4;      //(^�� ����)���߿� ���� ^�� ���� ����Ǿ����.
      else
         return 0;
   }
   private int getPrecedenceInStack(char op) { //stack�� ���� �����ڵ� �߿��� ��������
     if (op == '+' || op == '-')
           return 1;
     else if (op == '*' || op == '/')
           return 2;
     else if (op == '^')
           return 3;      //(^�� ����)�̹� �ִ� ^�� ���߿� ����Ǿ���.
      else
         return 0;
   }

   private void clearStack() {
      while (!stack.isEmpty()) {
         postfix.add(stack.pop().toString()); //postfix�� stack�� �����͵��� add
      }
   }

   public void printExpression() {
      for (String str : postfix) {
         System.out.print(str + ' '); //����ǥ��� �ٲ۰��� ���.
      }
   }

   public List<String> getPostfixAsList() { //����ǥ��� �ٲ۰�
      return postfix;
   }
}
//-------------------------------------------------------------------------------------------
class PostFixCalculator {  //��������
   private List<String> expression = new ArrayList<String>();
   private Stack<Double> stack = new Stack<Double>();

   public PostFixCalculator(List<String> postfix) {
      expression = postfix;
   }

   public double result() {
      for (int i = 0; i != expression.size(); ++i) { //���� ũ�⸸ŭ�� ���ư�����
         // Determine if current element is digit or not
         if (Character.isDigit(expression.get(i).charAt(0))) { //���� ù��°���� �������� �ƴ��� �Ǻ�,
            stack.push(Double.parseDouble(expression.get(i))); //�����̸� double�� �ٲ㼭 ���ÿ� push����.
         } else {  //���ڰ� �ƴҶ� (�������� ���) pop�ι� �ؼ� �����Ŵ, ����� ���� tempResult�� �ؼ� ���ÿ� push����.(�ؿ��� �������..)
            double tempResult = 0;
            double temp;

            switch (expression.get(i)) {
            case "+":
               temp = stack.pop(); //ù���� pop
               tempResult = stack.pop()/*�ι�° pop*/+ temp;//��������, ù��° pop�Ѱ��� �ڿ�, �ι��� pop�� ���� �տ��ؼ� �����ϱ�
               break;
           
            case "-":
               temp = stack.pop();
               tempResult = stack.pop() - temp;
               break;

            case "*":
               temp = stack.pop();
               tempResult = stack.pop() * temp;
               break;

            case "/":
               temp = stack.pop();
               tempResult = stack.pop() / temp;
               break;
               
            case "^":  //2 3 ^ �̸� temp�� 3 �ι�° pop()�� 2. 2�� temp��(3��) ���ؾ���. 2*2*2
               temp = stack.pop();
               double temp2= stack.pop();
               tempResult=1;
               for(int ii=0; ii< temp; ii++ ) {
               tempResult *= temp2;
               }
               break;
            }
            stack.push(tempResult); //����� ���� tempResult�� �ؼ� ���ÿ� push����.
         }
      }
      return stack.pop(); //�� �������� ���� tempResult���� result�� ������ pop�� �����ϸ� result����!!
   }
}
//------------------------------------------------------------------------------------
public class Calc {

   public static void main(String[] args) throws IOException {
      String expression;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter expression: ");
      expression = br.readLine(); //�Է��� ���� ����

      PostFixConverter pc = new PostFixConverter(expression);
      System.out.print("Postfix: ");
      pc.printExpression();   //�Էµ� ����(����ǥ��) ����ǥ��� �ٲ۰��� ���

      PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());
      System.out.println();
      System.out.println("Result: " + calc.result()); //����� ����� ���
   }
}                 
