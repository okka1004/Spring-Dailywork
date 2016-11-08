package exam_01_composition;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("입력해라잉~ : ");
		String keyword=s.nextLine();
		
		System.out.println("넌 이걸 입력했당 : "+keyword);
		
		BookService service=new BookService();
		
		ArrayList<BookEntity> list=service.getListByKeyword(keyword);
		
		for(BookEntity entity:list){
			System.out.println(entity.getBtitle()+" : " + entity.getBauthor());
		}
		
		//사용한 리소스 해제
		s.close();
		
	}

}
