/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     ybonnel - initial API and implementation
 */
package fr.ybo.transportsrennes;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import fr.ybo.transportsrennes.keolis.gtfs.modele.GroupeFavori;

public class TabFavoris extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabfavoris);

		TabHost tabHost = getTabHost();

		// Initialize a TabSpec for each tab and add it to the TabHost
		Intent intentTous = new Intent().setClass(this, ListFavoris.class);
		tabHost.addTab(tabHost.newTabSpec("all").setIndicator(getString(R.string.all)).setContent(intentTous));

		// Do the same for the other tabs
		for (GroupeFavori groupe : TransportsRennesApplication.getDataBaseHelper().selectAll(GroupeFavori.class)) {
			Intent intent = new Intent().setClass(this, ListFavoris.class);
			intent.getExtras().putString("groupe", groupe.name);
			tabHost.addTab(tabHost.newTabSpec(groupe.name).setIndicator(groupe.name).setContent(intent));
		}

		tabHost.setCurrentTab(0);
	}
}