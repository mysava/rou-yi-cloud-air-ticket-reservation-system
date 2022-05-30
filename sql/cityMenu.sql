-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区', '3', '1', 'city', 'system/city/index', 1, 0, 'C', '0', '0', 'system:city:list', '#', 'admin', sysdate(), '', null, '地区菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:city:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:city:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:city:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:city:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:city:export',       '#', 'admin', sysdate(), '', null, '');