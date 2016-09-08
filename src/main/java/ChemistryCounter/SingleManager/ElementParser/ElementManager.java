/*
 * Copyright (c) 2016.  Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued. Please contact the developer at sarhadmaisoon18@gmail.com.
 */

package ChemistryCounter.SingleManager.ElementParser;

import ChemistryCounter.Exceptions.ElementNotFoundException;
import ChemistryCounter.Exceptions.ParsingErrorException;
import ChemistryCounter.SingleManager.ElementParser.Universal.ElementDetails;
import ChemistryCounter.SingleManager.ElementParser.lib.Normal;
import ChemistryCounter.SingleManager.ElementParser.lib.Polyatomic;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sarha on 26-Apr-16.
 * Just handles on whether it's polyatomic or normal.
 */
public class ElementManager
{
	
	/**
	 * The method elements below determines whether its polyatomic or normal and forwards it to Polyatomic manager or
	 * Normal manager. The class ElementManager is responsible for managing elements.
	 * <p>
	 * This class acts like a middleman.
	 *
	 * @param chemicalCompound The chemical compound that was inputted by the user, which is forwarded by the parseElements.
	 *
	 * @return elementsList
	 *
	 * @throws IOException                  There is no files found.
	 * @throws SAXException                 No idea what this is
	 * @throws ParserConfigurationException The xml parser failed.
	 * @throws ElementNotFoundException     The element wasn't found.
	 */
	public static ArrayList<ElementDetails> elements(String chemicalCompound) throws ElementNotFoundException, SAXException, ParserConfigurationException, IOException, ParsingErrorException
	{
		ArrayList<ElementDetails> elementsList;
//		If polyatomic
		if( chemicalCompound.matches(".*\\(+.*") || chemicalCompound.matches(".*\\)+.*") )
		{
			elementsList = Polyatomic.manager(chemicalCompound);
		}

//		Only if it's numbers.
		else if( chemicalCompound.matches("\\d+") )
		{
			throw new ParsingErrorException("There is a parsing error.");
		}

//		If normal
		else
		{
			elementsList = Normal.manager(chemicalCompound);
		}
		return elementsList;
	}
}