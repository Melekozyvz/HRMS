package kodlamaoi.hrms;

import java.util.Date;

import kodlamaio.hrms.business.concretes.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrete.Candidate;

public class Test {

	public static void main(String[] args) {
		Candidate candidate=new Candidate("Melek","Tiftik","36529957624",new Date(1996,11,29));
		MernisServiceAdapter adapter=new MernisServiceAdapter();
		Result result= adapter.checkRealPerson(candidate);
		System.out.println("result:"+result.isSuccess());
	}
}
