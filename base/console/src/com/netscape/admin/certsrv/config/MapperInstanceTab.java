// --- BEGIN COPYRIGHT BLOCK ---
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; version 2 of the License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
// (C) 2007 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---
package com.netscape.admin.certsrv.config;

import com.netscape.admin.certsrv.*;
import com.netscape.admin.certsrv.connection.*;
import javax.swing.*;
import com.netscape.management.client.util.*;
import com.netscape.certsrv.common.*;

/**
 * Mapper Instances Management Tab
 *
 * @author Steve Parkinson
 * @version $Revision$, $Date$
 * @see com.netscape.admin.certsrv.config
 */
public class MapperInstanceTab extends CMSPluginInstanceTab {

    /*==========================================================
     * variables
     *==========================================================*/
    private static final String PANEL_NAME = "MAPPERRULE";

    private final static String RAHELPINDEX = "configuration-ra-mapperinstances-help";
    private final static String CAHELPINDEX = "configuration-ca-mapperinstances-help";
    private final static String KRAHELPINDEX = "configuration-kra-mapperinstances-help";


	/*==========================================================
     * constructors
     *==========================================================*/
    public MapperInstanceTab(CMSBaseResourceModel model, String dest) {
        super(model,dest,PANEL_NAME);
		Debug.println("MapperInstanceTab::MapperInstanceTab(<model>,"+dest);
        mConnection = model.getServerInfo().getAdmin();
        mDataModel = new MapperRuleDataModel();
		mScope = ScopeDef.SC_MAPPER_RULES;
		RULE_NAME = MapperRuleDataModel.RULE_NAME;
		RULE_STAT = MapperRuleDataModel.RULE_STAT;

        if (mDestination.equals(DestDef.DEST_RA_MAPPER_ADMIN))
            mHelpToken = RAHELPINDEX;
        else
            mHelpToken = CAHELPINDEX;
    }


	public CMSBaseConfigDialog makeNewConfigDialog(
			NameValuePairs nvp,
			JFrame parent,
			AdminConnection conn,
			String dest
			)
	{

		return new MapperConfigDialog(nvp,
			parent,
			conn,
			dest);
	}

	public PluginSelectionDialog getPluginSelectionDialog(
			JFrame parent,
			AdminConnection conn,
			String dest,
			CMSPluginInstanceTab pluginType
			)
	{
		return new MapperPluginSelectionDialog(parent,conn,dest,pluginType);
	}


}
