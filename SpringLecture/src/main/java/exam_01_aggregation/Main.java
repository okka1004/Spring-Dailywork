package exam_01_aggregation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("입력해라잉~ : ");
		String keyword=s.nextLine();
		
		System.out.println("넌 이걸 입력했당 : "+keyword);
		
		BookDAO dao=new BookDAO();
		BookService service=new BookService(dao);
		
		ArrayList<BookEntity> list=service.getListByKeyword(keyword);
		
		for(BookEntity entity:list){
			System.out.println(entity.getBtitle()+" : " + entity.getBauthor());
		}
		
		//사용한 리소스 해제
		s.close();
		
	}

}
