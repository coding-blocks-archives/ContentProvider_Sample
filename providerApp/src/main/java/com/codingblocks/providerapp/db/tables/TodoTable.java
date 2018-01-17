package com.codingblocks.providerapp.db.tables;

import static com.codingblocks.providerapp.db.Consts.*;

/**
 * Created by championswimmer on 17/01/18.
 */

public class TodoTable {

    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + LBR
            + Columns.ID  + TYPE_PK_AI + COMA
            + Columns.TASK + TYPE_TEXT + COMA
            + Columns.DONE + TYPE_BOOL
            + RBR + SEMICOL;

}
