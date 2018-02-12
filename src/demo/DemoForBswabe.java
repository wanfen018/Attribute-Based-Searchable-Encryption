
package demo;
import index.Index;
import it.unisa.dia.gas.jpbc.Element;
import scheme.Bswabe;
import scheme.BswabeCph;
import scheme.BswabeMsk;
import scheme.BswabePrv;
import scheme.BswabePub;
import scheme.BswabeToken;

public class DemoForBswabe {
	final static boolean DEBUG = true;
	/*final static String inputfile = "F://dataEclipse/keyword.txt";
	final static String encfile = "F://dataEclipse/cipher.txt";
	final static String decfile = "F://dataEclipse/result.txt";//输出搜索结果：文件的id或者TRUE/false
*/
	
	//universal attribute set, any attribute is in u. 
	final static String []u={"ECNU","teacher", "doctor","master","bachelor","2016","2015","2014"};
	//attributes of the user
	final static String []attrs = {"ECNU","teacher","2015"};
	//attributes of the policy
	final static String []policy = {"ECNU","teacher","2015"};
	final static String []file = {"1","3","5","6"};//包含关键字的文件标识
	final static Index index = new Index("12",file); //要加密的部分
	final static String word = "123";//要搜索的部分


	public static void main(String[] args) throws Exception {
		BswabePub pub = new BswabePub();
		BswabeMsk msk = new BswabeMsk();
		BswabePrv prv;
		BswabeToken token;
		BswabeCph cph;

		boolean result = false;	

		println("//demo for bswabe: start to setup");
		Bswabe.setup(u,pub, msk);
		println("//demo for bswabe: end to setup");

		println("\n//demo for bswabe: start to enc");
		cph = Bswabe.enc(u,pub, policy, index);
		println("//demo for bswabe: end to enc");	
		
		println("\n//demo for bswabe: start to keygen");
		prv = Bswabe.keygen(u,pub, msk, attrs);
		println("//demo for bswabe: end to keygen");

		println("\n//demo for bswabe: start to tokengen");
		token = Bswabe.tokgen(prv,pub,word);
		println("\n//demo for bswabe: end to tokengen");

		println("\n//demo for bswabe: start to search");
		result = Bswabe.search(pub, token, cph);
		println("//demo for bswabe: end to dec");
		if (result){
			String []fileReturned = index.file;
			for(int i=0;i<fileReturned.length;i++)
				System.out.print(fileReturned[i]+" ");
			System.out.println();
		}
		else
			System.err.println("There are no results!");
	
	
	}

	private static void println(Object o) {
		if (DEBUG)
			System.out.println(o);
	}
}
