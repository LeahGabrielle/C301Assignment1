    //Copyright (C) 2015 Leah Olexson

    //This program is free software; you can redistribute it and/or modify
    //it under the terms of the GNU General Public License as published by
    //the Free Software Foundation; either version 2 of the License, or
    //(at your option) any later version.

    //This program is distributed in the hope that it will be useful,
    //but WITHOUT ANY WARRANTY; without even the implied warranty of
    //MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    //GNU General Public License for more details.

    //You should have received a copy of the GNU General Public License along
    //with this program; if not, write to the Free Software Foundation, Inc.,
    //51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.util.ArrayList;

public class ClaimList  implements Serializable{
	
	private static final long serialVersionUID = 6673446047991058932L;
	protected ArrayList <Claim> claims = null;
	protected transient ArrayList<Listener> listeners = null;
	
	public ClaimList(){
		super();
		claims= new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}

	public ClaimList(ArrayList<Claim> claims) {
		super();
		this.claims = claims;
		listeners = new ArrayList<Listener>();
	}
	
	public ArrayList<Claim> getClaims() {
		return claims;
	}
	public void setClaims(ArrayList<Claim> claims) {
		this.claims = claims;
	}
	
	private ArrayList<Listener> getListeners(){
		if (listeners==null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	//Claims should be ordered by date, but are not
	//add a claim to the list of claims
	public void addClaim(Claim claim){
		this.claims.add(claim);
		notifyListeners();
	}
	private void notifyListeners() {
		for (Listener listener:getListeners()){
			listener.update();
		}
	}

	//delete a claim from the list of claims
	public ArrayList<Claim> deleteClaim(Claim claim){
		this.claims.remove(claim);
		notifyListeners();
		return this.claims;
	}
	
	public void addListener(Listener l){
		getListeners().add(l);
	}
	
	public void removeListener(Listener l){
		getListeners().remove(l);
	}
	
	
}
