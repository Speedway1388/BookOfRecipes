package com.softserve.edu.items.dao;

import com.softserve.edu.items.entity.SqlQueries;
import com.softserve.edu.items.entity.User;
import com.softserve.edu.items.entity.User.UserEntityQueries;

import java.util.ArrayList;
import java.util.List;

public final class UserDao extends ADaoCRUD<User> {
	private final static String USERNAME_FIELDNAME = "username";

	public UserDao() {
		super();
		init();
	}


	protected void init() {
		for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
			sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
		}
	}


	protected User createInstance(List<String> args) {
		int length = args.size();
		return new User(
                (length<1) ? Long.valueOf("0") : Long.valueOf(args.get(0)),
//                Long.parseLong(args.get(0)),
				(length<2)?new String():args.get(1),
				(length<3)?new String():args.get(2),
				(length<4)?new String():args.get(3),
				(length<5)?1:Integer.valueOf(args.get(4)),
				(length<6)?0:Integer.valueOf(args.get(5)));
	}

	protected List<String> getUpdateFields(User entity) {

		List<String> result = new ArrayList<>();
		List<String> allFields=getFields(entity);
		result.add(0,allFields.get(3));
		result.add(1,allFields.get(2));
		result.add(2,allFields.get(0));
		return result;
	}

    protected List<String> getFields(User entity) {
		//String[] fields = new String[User.class.getDeclaredFields().length];
		List<String> fields=new ArrayList<>();
		fields.add(0,entity.getId().toString());
		fields.add(1,entity.getUsername());
		fields.add(2,entity.getEmail());
		fields.add(3,entity.getPassword());
		fields.add(4, entity.getIsactive().toString());
		fields.add(5, entity.getIsadmin().toString());
		return fields;
	}

	public User getUserEntityByUsername(String username) {
		return getByFieldName(USERNAME_FIELDNAME, username).get(0);
	}

	@Override
	public String getOneFieldName(String fieldName) {
		return null;
	}


}
