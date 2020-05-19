package data;

import utils.PropertyReader;

public class TestData {

    public static final String BASE_URL = new PropertyReader().get("url.path.go.dev");

    public static final String MENU_ITEM1 = "Why Go";
    public static final String MENU_ITEM2 = "Getting Started";
    public static final String MENU_ITEM3 = "Discover Packages";
    public static final String MENU_ITEM4 = "About";

    public static final String TAB_ITEM1 = "Doc";
    public static final String TAB_ITEM2 = "Overview";
    public static final String TAB_ITEM3 = "Subdirectories";
    public static final String TAB_ITEM4 = "Versions";
    public static final String TAB_ITEM5 = "Imports";
    public static final String TAB_ITEM6 = "Imported By";
    public static final String TAB_ITEM7 = "Licenses";

    public static final String SEARCH_DATA = "setter";
    public static final String PROJECT_NAME = "github.com/mikekonan/protoc-gen-setter";

    public static final String PROJECT_PUBLISHED = "Apr 13, 2020";
    public static final String PROJECT_LICENSES = "None detected";

    public static String messageElementNotDisplayed = "Element '%s' is not displayed";
    public static String messageLinkIsNullOrEmpty = "Link '%s' is null or empty";
    public static String messageElementIncorrectValue = "Element has incorrect value: '%s', expected: '%s'";
}
