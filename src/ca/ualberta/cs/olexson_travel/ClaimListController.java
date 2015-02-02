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

import java.io.IOException;

public class ClaimListController {
	
	private static ClaimList claimlist = null;
	//Warning: throws runTimeException
	static public ClaimList getClaimList() {
		if (claimlist ==null){
			try{
				claimlist = ClaimListManager.getManager().loadClaimList();
				claimlist.addListener(new Listener() {
					@Override
					public void update(){
						saveClaimList();
					}
				});
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException ("Could not deserialize ClaimList from ClaimListManager");	
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Could not deserialize ClaimList from ClaimListManager");
			}
		}
		return claimlist;
	}
	static public void saveClaimList() {
		try {
			ClaimListManager.getManager().saveClaimList(getClaimList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Could not deserialize ClaimList from ClaimListManager");
		}
	}

	public void addClaim(Claim claim) {
		getClaimList().addClaim(claim);
	}
}
