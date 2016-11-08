package dailyWork1;

import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("입력하세요");
		String keyword=input.nextLine();

		String config="classpath:applicationCtx.xml";
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext(config);
		BookService service=ctx.getBean("BookService", BookService.class);
		ArrayList<BookEntity> list=service.getListByKeyword(keyword);
		
		for(BookEntity entity:list){
			System.out.println(entity.getBtitle()+" : "+entity.getBauthor());
			
			ArrayList<String> commentList=new ArrayList();
			commentList=entity.getCtext();
			
			for(String s:commentList){
				System.out.println("====>"+s);
			}

		}
		ctx.close();
		input.close();
	}

}
