/**
 * Created on 28.05.2003 
 */

package org.cocons.argo.cognitive.critics;
/**
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 */
public final class CriticInfo
{
	private String Reason ="";
	private String HeadLine="";
	
	public String getCriticReason()
	{
		return Reason;
	}
	
	public void SetCriticReason(String reason)
	{
		Reason = reason;
	}
	
	public String getCriticHeadLine()
	{
		return HeadLine;
	}
	
	public void setCriticHeadLine(String headline)
	{
		HeadLine= headline;
	}
}
