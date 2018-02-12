package scheme;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;

public class BswabePub{
	/*
	 * A public key
	 */
	public String pairingDesc;
	public Pairing p;		
	public Element g1;				/* G_1*/
	public Element g_a;				/* G_1 */
	public Element g_b;				/* G_1 */
	public Element g_c;				/* G_1 */
	public Element []u ;            /* G_1*/
	public Element []y ;            /* G_T*/
	public Element g2;			    /* G_2 */

	
	
			
	
	//public Element gp;			/* G_2 */
	//public Element g_hat_alpha;	/* G_T */
}
