-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight', '1', '1', 'flight', 'system/flight/index', 1, 0, 'C', '0', '0', 'system:flight:list', '#', 'admin', sysdate(), '', null, 'flight菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:flight:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:flight:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:flight:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:flight:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('flight导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:flight:export',       '#', 'admin', sysdate(), '', null, '');