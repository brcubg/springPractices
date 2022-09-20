package com.brcubg.demoSpringProject.constant;

public final class ApiPaths {

    public ApiPaths() {
    }

    private static final String PATH_DELIMETER = "/";
    private static final String BASE_PATH = PATH_DELIMETER + "api";

    public static final class UserPaths{

        public UserPaths() {
        }
        private static final String ROOT_PATH = BASE_PATH + "/user";
        public static final String CREATE_PATH = ROOT_PATH + "/create";
        public static final String UPDATE_PATH = ROOT_PATH + "/update/{id}";
        public static final String DELETE_PATH = ROOT_PATH + "/delete/{id}";
        public static final String QUERY_PATH = ROOT_PATH + "/list";
        public static final String GET_USER_PATH = ROOT_PATH + "/get/{id}";
    }

    public static final class RolePaths{
        public RolePaths() {
        }
        private static final String ROOT_PATH = BASE_PATH + "/role";
        public static final String CREATE_PATH = ROOT_PATH + "/create";
        public static final String UPDATE_PATH = ROOT_PATH + "/update";
        public static final String DELETE_PATH = ROOT_PATH + "/delete";
        public static final String QUERY_PATH = ROOT_PATH + "/list";
        public static final String GET_ROLE_PATH = ROOT_PATH + "/get/{id}";

    }
}
