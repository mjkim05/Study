/*========================================
  ���� ���� �帧�� ��Ʈ�� (���) ����
  - switch�� �ǽ� 
  ==========================================*/

  // ����ڷκ��� ������ �� ������ �����ڸ� �Է¹޾�
  // �ش� �����ڿ� ���� ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
  // ��, switch���� Ȱ���Ͽ� ó�� �� �� �ֵ��� �Ѵ�.
  // ���� ����� ���ǻ� ���� ���·� ó�� �� �� �ֵ��� �Ѵ�.

  // ���� ��)
  // ù ��° ���� �Է�		: 
  // �� ��° ���� �Է�		:
  // ������ �Է�[+ - * /]	:

  // >> 3 - 17 = -14
  // ����Ϸ��� �ƹ�Ű�� ��������...

  import java.io.BufferedReader;
  import java.io.InputStreamReader;
  import java.io.IOException;


public class Test042
{
	public static void main(String[] args)	throws IOException
	{

		// ���� �ۼ��� �ڵ� ------------------------------------------------------------------------------------------------
		/*
		// �ֿ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num1, num2;								//����ڰ� �Է��� ������ ����
		char op;									//����ڰ� �Է��� ������

		// ���� �� ó��
		System.out.print("ù ��° ���� �Է�	:");
		num1 = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է�	:");
		num2 = Integer.parseInt(br.readLine());
		System.out.print("������ �Է� [+ - * /] :");
		op = (char)System.in.read();
	
		switch (op)
		{
		case'+': System.out.printf("\n>> %d + %d = %d \n", num1, num2, (num1+num2)); break;
		case'-': System.out.printf("\n>> %d - %d = %d \n", num1, num2, (num1-num2)); break;
		case'*': System.out.printf("\n>> %d * %d = %d \n", num1, num2, (num1*num2)); break;
		case'/': System.out.printf("\n>> %d / %d = %d \n", num1, num2, (num1/num2)); break;
		default: System.out.println("�����ڰ� �߸� �Է� �ƽ��ϴ�.");
		}
		*/

		//���� ��� 
		/*
		ù ��° ���� �Է�       :5
		�� ��° ���� �Է�       :10
		������ �Է� [+ - * /] :+

		>> 5 + 10 = 15
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/

		/*
		ù ��° ���� �Է�       :5
		�� ��° ���� �Է�       :1
		������ �Է� [+ - * /] :=
		
		�����ڰ� �߸� �Է� �ƽ��ϴ�.
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
		*/
		// -----------------------------------------------------------------------------------------------------------------

		// �����ϸ� �Բ� �ۼ��� �ڵ� ---------------------------------------------------------------------------------------

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ��
		int a, b, result;
		String op;

		System.out.print("ù ���� ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� [+ - * /]: ");
		op = br.readLine();

		switch (op)
		{
		case "+": result = a + b; break;
		case "-": result = a - b; break;
		case "*": result = a * b; break;
		case "/": result = a / b; break;
		default: return;
		
		}

		System.out.printf("\2n>> %d %s %d = %d\n",a, op, b, result);
		// ��
		/*
		int a,b,result;
		int op;

		System.out.print("ù ��° ���� �Է�		: ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է�		: ");
		b = Integer.parseInt(br.readLine());

		System.out.print ("������ �Է�[+ - * /] :");
		op = System.in.read();

		// +  �� 43, - �� 45, * �� 42, / �� 47
		switch (op)
		{
		case 43: result = a + b; break;
		case 45: result = a - b; break;
		case 42: result = a * b; break;
		case 47: result = a / b; break;		
		default: return;				//-- 1. ���� ��ȯ		
										//-- 2. �޼ҵ� ����		�� main() �޼ҵ� ���� �� ���α׷� ����!
		}

		System.out.println();
		System.out.printf(" >> %d %c %d = %d\n", a, op, b, result);
		*/
		// ��
		/*
		int a, b, result;
		char op;

		System.out.print("ù ���� ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		System.out.print("������ �Է� [+ - * /]: ");
		op = (char)System.in.read();

		switch (op)
		{
		case '+': result = a + b; break;
		case '-': result = a - b; break;
		case '*': result = a * b; break;
		case '/': result = a / b; break;
		default: return;
		
		}

		System.out.printf("/n>> %d %c %d = %d\n",a, op, b, result);
		*/
		//------------------------------------------------------------------------------------------------------------------
	} 
}

//���� ���

/*
ù ���� ���� �Է� : 5
�� ��° ���� �Է� : 20
������ �Է� [+ - * /]: +
>> 5 + 20 = 25
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

ù ���� ���� �Է� : 5
�� ��° ���� �Է� : 10
������ �Է� [+ - * /]: =
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/