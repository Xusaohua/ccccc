package ruanjiangongcheng;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class hanhan1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("运算多少道题？");
		Scanner read = new Scanner(System.in);
		String num = read.nextLine();
		System.out.println("范围是	多少？");
//		Scanner read1 = new Scanner(System.in);
		String scope = read.nextLine();
		String regex = "^[0-9]*$";
		Pattern p = Pattern.compile(regex);
		if (!(num.equals("") || scope.equals(""))) {
			Matcher m = p.matcher(num);
			Matcher n = p.matcher(scope);
			if (m.matches()) {
				if (n.matches())
					flag = true;
			}
			if (flag) {
				System.out.println("输入成功，请在D盘的result.txt中查看");
				HomeWorkDemo_1.fun(Integer.parseInt(num), Integer.parseInt(scope));
				
			} else {
				throw new MyExcep("输入类型异常,请输入数字！！！！");
			}
		} else {
			throw new MyExcep("输入类型异常,您不能什么也不输入！！！！");
		}

		// HomeWorkDemo_1.fun(num, scope);
	}
}

class HomeWorkDemo_1 {
	public static void fun(int count, int scope) {
		int count1 = count;
		Random random = new Random();
		// 把每个随机的数都存进去
		int[] num = new int[1000];
		int[] symbol = new int[100];
		// 将每两个数运算的结果存进去
		int[] total = new int[500];
		int number_1 = 0, number_2 = 0, number_3 = 0, number_4 = 0, number_5 = 0, number_6 = 0, number_7 = 0,
				number_8 = 0;
		for (int i = 0; i < count; i++) {
			num[number_1++] = random.nextInt(scope) + 1;
			num[number_1++] = random.nextInt(scope) + 1;
			number_5 = random.nextInt(4) + 1;
			int flag = number_5 % 4;
			switch (flag) {
			case 0:
				total[number_3++] = (num[number_2++]) + (num[number_2++]);
				break;
			case 1:
				total[number_3++] = (num[number_2++]) - (num[number_2++]);
				break;
			case 2:
				total[number_3++] = (num[number_2++]) * (num[number_2++]);
				break;
			case 3:
				total[number_3++] = (num[number_2++]) / (num[number_2++]);
				break;
			}
			symbol[number_6++] = flag;
			if (number_4 <= count) {
				if (total[number_4++] > 100) {
					number_1--;
					number_1--;
					number_2--;
					number_2--;
					number_3--;
					number_4--;
					number_6--;
					count++;
				}
			}
		}
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fw = new FileWriter("D:\\result.txt");
			bufw = new BufferedWriter(fw);
			for (int i = 0; i < count1; i++) {
				switch (symbol[number_7++]) {
				case 0:
					bufw.write("第" + (int) (i + 1) + "题:"
							+ new String(num[number_8++] + "+" + num[number_8++] + "=" + total[i]));
					bufw.newLine();
					break;
				case 1:
					bufw.write("第" + (int) (i + 1) + "题:"
							+ new String(num[number_8++] + "-" + num[number_8++] + "=" + total[i]));
					bufw.newLine();
					break;
				case 2:
					bufw.write("第" + (int) (i + 1) + "题:"
							+ new String(num[number_8++] + "*" + num[number_8++] + "=" + total[i]));
					bufw.newLine();
					break;
				case 3:
					bufw.write("第" + (int) (i + 1) + "题:"
							+ new String(num[number_8++] + "/" + num[number_8++] + "=" + total[i]));
					bufw.newLine();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufw != null) {
					bufw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyExcep extends RuntimeException {
	MyExcep(String msg) {
		super(msg);
	}
}