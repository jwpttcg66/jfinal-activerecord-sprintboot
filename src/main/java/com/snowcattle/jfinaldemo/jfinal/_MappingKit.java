package com.snowcattle.jfinaldemo.jfinal;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.snowcattle.jfinaldemo.jfinal.model.Emp;
import com.snowcattle.jfinaldemo.jfinal.model.EmpBalance;

public class _MappingKit {
    public static void mapping(ActiveRecordPlugin arp) {
        arp.addMapping("emp", Emp.class);
        arp.addMapping("emp_balance", EmpBalance.class);
    }
}
