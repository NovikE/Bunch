package flowers.runner;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import flowers.action.RibbonSaxHandler;
import flowers.bean.Bunch;
import flowers.bean.Flower;
import flowers.bean.Ribbon;
import flowers.dao.FlowerFileDaoImp;
import flowers.dao.bd.BunchDaoMySqlImpl;
import flowers.dao.bd.FlowerDaoMySqlImpl;
import flowers.exceptions.MyExceptionIncorrectLength;
import flowers.exceptions.MyExceptionNegVal;
import flowers.exceptions.MyTechnicalException;
import flowers.logic.BunchInfo;
import flowers.logic.EditFlower;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class Main {

	public static void main(String[] args) throws MyTechnicalException, MyExceptionIncorrectLength, MyExceptionNegVal, IOException, SAXException, ParserConfigurationException {

		FlowerFileDaoImp flowers = new FlowerFileDaoImp();

		Map<Integer, Integer> req = new HashMap<Integer, Integer>();

		System.out.println("Please, enter quantity of each flower. If you don't want special flower, enter 0.");
		for (Flower s: flowers.readAll()){
			System.out.print(s.getTitle() + ": ");
			Scanner in = new Scanner(System.in);
			int q = 0;
			try{
			q = in.nextInt();
				if (q < 0) {
					throw new MyExceptionNegVal("Negative value is not expected!");}
			} catch (InputMismatchException e){
				throw new MyTechnicalException("Incorrect symbols in string.", e);
			}catch (NullPointerException e){
				System.out.println("Need to enter a number! ");
				q = 0;
			}
			req.put(s.getId(), q);
		}


		System.out.println("Request: " + req.toString());

		///////////////////////////////XML
		//XMLReader reader = XMLReaderFactory.createXMLReader();

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		RibbonSaxHandler handler = new RibbonSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src/main/resources/ribbons.xml"));
		List<Ribbon> ribbonList = handler.getRibbonList();
		System.out.println("Please, select any ribbon: ");
		for (Ribbon ribbon : ribbonList) {
			System.out.println(ribbon.getId()+ " " + ribbon.getColor() + " " + ribbon.getLength() + " " + ribbon.getPrice());
		}
		Scanner in = new Scanner(System.in);
		int myId = in.nextInt();

		int index = 0;

		for (Ribbon ribbon : ribbonList) {
			if (ribbon.getId() == myId) {
				index = ribbonList.indexOf(ribbon);
				break;
			}
		}
		/////////////////////////////////end XML

		BunchDaoMySqlImpl bunchDao = new BunchDaoMySqlImpl();
		int bunch_id = bunchDao.getMaxId()+ 1;
		Bunch bunch = new Bunch(bunch_id, req, index);
		BigDecimal bd = new BigDecimal(bunch.sumBrunch(flowers.readAll(), ribbonList));
		try {
			bd = bd.setScale(2, RoundingMode.HALF_EVEN);
			//bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		}catch (ArithmeticException e){
			System.out.println("Sum of bunch is incorrect!");
			bd = new BigDecimal(0);
		}
		System.out.println("Price of bunch: " + bd + " BYN");

		BunchInfo prnt = new BunchInfo();
		prnt.printBunchInfo(bunch, flowers.readAll());
		bunchDao.create(bunch);

		EditFlower ef = new EditFlower();

		List<Flower> newFlowers = new ArrayList<>();

		for (Flower fl: flowers.readAll()) {
			newFlowers.add(fl);
		}
		flowers.clearFile("c:\\data\\flower_storage.txt");

		ef.editQuantity(bunch, newFlowers);
		for (Flower fl: newFlowers) {
			flowers.addFlower(fl);
		}
		///read from table flowers
		FlowerDaoMySqlImpl flowerDao = new FlowerDaoMySqlImpl();
		List<Flower> listFlowers;
		listFlowers = flowerDao.readAll();
		for (Flower fl: listFlowers) {
			if(fl != null){
			System.out.println(fl.toString());}
		}
		///end read from table
	}

}
