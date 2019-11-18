package ss;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//먼저 중위표기의 수식을 받고, 이를 후위표기법으로 바꾼 후, 계산.
//---------------------------------------------------------------------------------------
class PostFixConverter { //후위표기로 변환하기
   private String infix; //중위표기
   private Stack<Character> stack = new Stack<Character>(); //연산자들 넣는 stack
   private List<String> postfix = new ArrayList<String>();  //후위표기

   public PostFixConverter(String expression) {
      infix = expression; //받은 식
      convertExpression();
   }

   private void convertExpression() { 
      StringBuilder temp = new StringBuilder();  //숫자만 있는 스트링빌더

      for (int i = 0; i != infix.length(); ++i) {
         if (Character.isDigit(infix.charAt(i))) { //중위표기인 받은 수식의 i번째가 숫자면 temp에 append.
            temp.append(infix.charAt(i));

              while ((i + 1) != infix.length()
                  && (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.')) {
                 //그 다음 거가 마지막아닐때+다음거가 숫자거나 .(소숫점)일때 -->소숫점을 판별하기 위해 
               temp.append(infix.charAt(++i));    //temp에 그 다음걸 append
              }

            postfix.add(temp.toString());  //후위에 temp에 저장된걸 스트링으로 바꿔서 add
            temp.delete(0, temp.length()); //tmep 내용을 싹 지움->temp에 숫자 한개 넣고 postfix에 저장 temp비움 반복(소숫점인 경우 하나의 수로 저장될수 있도록)
         }

         else
            inputToStack(infix.charAt(i)); //중위표기인 받은식의 숫자가 아나라면, 연산자라면 stack에 넣는 함수
      }
      clearStack(); //스택을 비우면서 후위연산자뒤에 pop하면서 push해주는 함수. postfix뒤에 stack을 이어줌
   }

   private void inputToStack(char input) { //연산자 넣기
      if (stack.isEmpty() || input == '(') //스택이 비었거나 (면 stack에 push
         stack.push(input);
      else {
         if (input == ')') { //닫는 괄호 )인 경우  
            while (!stack.peek().equals('(')) { //맨위 스택이 (일때까지 반복
               postfix.add(stack.pop().toString()); // (이면 stack에서 pop한걸 스트링으로 바꿔 postfix에 add
            }
            stack.pop(); //
         } else { // 닫는 괄호 )가 아닌경우
            if (stack.peek().equals('(')) //여는 괄호 ( 와 같으면 stack에 push
               stack.push(input);
            else {  // )도 (도 아닌경우 
               while (!stack.isEmpty() && !stack.peek().equals('(')  //stack이 비어있고+stack에 (가 없고
                     && getPrecedenceInComing(input) <= getPrecedenceInStack(stack.peek())) { //+(받은 식에서 가져온 우선순위<=stack의 우선순위)
                  postfix.add(stack.pop().toString());  //이미 있는 스택의 우선순위가 더 놓을 때 stack을 pop한 걸 스트링으로 변환후 postfix에 add
               }
               stack.push(input); //받은 식의 가져올 연산자의 우선순위가 더 높을 경우 stack에 넣음.
            }
         }
      }
   }
//우선순위(return숫자기 높을수록 먼저 계산하게함) : +,- < *,/ < ^
   private int getPrecedenceInComing(char op) { //받은 연산자들 중에서 순위정함
      if (op == '+' || op == '-')
         return 1;
      else if (op == '*' || op == '/')
         return 2;
      else if (op == '^')
         return 4;      //(^들 끼리)나중에 들어올 ^가 먼저 연산되어야함.
      else
         return 0;
   }
   private int getPrecedenceInStack(char op) { //stack에 쌓인 연산자들 중에서 순위정함
     if (op == '+' || op == '-')
           return 1;
     else if (op == '*' || op == '/')
           return 2;
     else if (op == '^')
           return 3;      //(^들 끼리)이미 있는 ^가 나중에 연산되야함.
      else
         return 0;
   }

   private void clearStack() {
      while (!stack.isEmpty()) {
         postfix.add(stack.pop().toString()); //postfix에 stack에 남은것들을 add
      }
   }

   public void printExpression() {
      for (String str : postfix) {
         System.out.print(str + ' '); //후위표기로 바꾼것을 출력.
      }
   }

   public List<String> getPostfixAsList() { //후위표기로 바꾼것
      return postfix;
   }
}
//-------------------------------------------------------------------------------------------
class PostFixCalculator {  //후위계산기
   private List<String> expression = new ArrayList<String>();
   private Stack<Double> stack = new Stack<Double>();

   public PostFixCalculator(List<String> postfix) {
      expression = postfix;
   }

   public double result() {
      for (int i = 0; i != expression.size(); ++i) { //식의 크기만큼만 돌아가게함
         // Determine if current element is digit or not
         if (Character.isDigit(expression.get(i).charAt(0))) { //식의 첫번째부터 숫자인지 아닌지 판별,
            stack.push(Double.parseDouble(expression.get(i))); //숫자이면 double로 바꿔서 스택에 push해줌.
         } else {  //숫자가 아닐때 (연산지인 경우) pop두번 해서 연산시킴, 연산된 값을 tempResult로 해서 스택에 push해줌.(밑에도 써뒀지만..)
            double tempResult = 0;
            double temp;

            switch (expression.get(i)) {
            case "+":
               temp = stack.pop(); //첫번쨰 pop
               tempResult = stack.pop()/*두번째 pop*/+ temp;//공통으로, 첫번째 pop한것을 뒤에, 두번쨰 pop한 것을 앞에해서 연산하기
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
               
            case "^":  //2 3 ^ 이면 temp가 3 두번째 pop()이 2. 2를 temp번(3번) 곱해야함. 2*2*2
               temp = stack.pop();
               double temp2= stack.pop();
               tempResult=1;
               for(int ii=0; ii< temp; ii++ ) {
               tempResult *= temp2;
               }
               break;
            }
            stack.push(tempResult); //연산된 값을 tempResult로 해서 스택에 push해줌.
         }
      }
      return stack.pop(); //맨 마지막에 남은 tempResult값이 result가 됨으로 pop을 리턴하면 result값임!!
   }
}
//------------------------------------------------------------------------------------
public class Calc {

   public static void main(String[] args) throws IOException {
      String expression;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter expression: ");
      expression = br.readLine(); //입력한 식을 읽음

      PostFixConverter pc = new PostFixConverter(expression);
      System.out.print("Postfix: ");
      pc.printExpression();   //입력된 식을(중위표기) 후위표기로 바꾼것을 출력

      PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());
      System.out.println();
      System.out.println("Result: " + calc.result()); //계산한 결과를 출력
   }
}                 
