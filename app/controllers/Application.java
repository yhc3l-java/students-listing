package controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Student;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.students;

public class Application extends Controller {
    public static Result index(String orderBy, String orderDirection, int currentPage) {
    	List<Student> studentsList = getStudents(orderBy, orderDirection, currentPage);
    	
    	int numberOfPages = (int) Math.ceil(studentsList.size() / 5.0);
    	
		List<Student> studentsOfCurrentPage = studentsList.subList((currentPage - 1) * 5, Math.min((currentPage) * 5, studentsList.size()));
		
		return ok(students.render(orderBy, orderDirection, numberOfPages, currentPage, studentsOfCurrentPage));
    }
    
	private static List<Student> getStudents(final String orderBy, final String orderDirection, int page) {
		List<Student> studentsList = getStudents();
    	
    	sort(studentsList, orderBy, orderDirection);
		return studentsList;
	}

	private static void sort(List<Student> studentsList, final String orderBy, final String orderDirection) {
		Collections.sort(studentsList, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if("id".equals(orderBy)){
					return ("asc".equals(orderDirection) ? 1 : -1) * a.id.compareTo(b.id);
				}
				if("name".equals(orderBy)){
					return ("asc".equals(orderDirection) ? 1 : -1) * a.name.compareTo(b.name);
				}
				if("surname".equals(orderBy)){
					return ("asc".equals(orderDirection) ? 1 : -1) * a.surname.compareTo(b.surname);
				}
				if("icon".equals(orderBy)){
					return ("asc".equals(orderDirection) ? 1 : -1) * a.icon.compareTo(b.icon);
				}
				return 0;
			}
		});
	}

	private static List<Student> getStudents() {
		return Arrays.asList(new Student[]{
				new Student(1,"Rachel","Morgan","wrench"),
				new Student(2,"Craig","Taylor","minus"),
				new Student(3,"Jean","King","legal"),
				new Student(4,"Jacqueline","Stewart","key"),
				new Student(5,"Jerry","Thompson","microphone-slash"),
				new Student(6,"Annie","Allen","leaf"),
				new Student(7,"Doris","Bailey","gift"),
				new Student(8,"Judith","Wood","calendar-o"),
				new Student(9,"Harry","Reed","flag-checkered"),
				new Student(10,"Sara","Edwards","flag"),
				new Student(11,"Kenneth","Patterson","ellipsis-h"),
				new Student(12,"James","Jones","sort-numeric-asc"),
				new Student(13,"Susan","Wright","download"),
				new Student(14,"Todd","Martinez","external-link"),
				new Student(15,"Kevin","Howard","anchor"),
				new Student(16,"Ruth","Williams","thumbs-o-up"),
				new Student(17,"Heather","Smith","fighter-jet"),
				new Student(18,"Irene","Hughes","square"),
				new Student(19,"Kelly","Nelson","retweet"),
				new Student(20,"Mildred","Robinson","circle-o"),
				new Student(21,"Patrick","White","phone-square"),
				new Student(22,"Deborah","Simmons","square-o"),
				new Student(23,"Benjamin","Butler","rocket"),
				new Student(24,"Scott","James","power-off"),
				new Student(25,"Arthur","Ross","level-up"),
				new Student(26,"Joseph","Lee","video-camera"),
				new Student(27,"Gregory","Harris","print"),
				new Student(28,"Judy","Barnes","code-fork"),
				new Student(29,"Debra","Hill","bell-o"),
				new Student(30,"Douglas","Watson","tag"),
				new Student(31,"Janet","Lewis","fire-extinguisher"),
				new Student(32,"Martha","Washington","cloud-upload"),
				new Student(33,"Katherine","Ramirez","star-half-full"),
				new Student(34,"Helen","Bennett","minus-square-o"),
				new Student(35,"Justin","Davis","lemon-o"),
				new Student(36,"Anthony","Gonzales","fire"),
				new Student(37,"Andrew","Cox","location-arrow"),
				new Student(38,"Jeffrey","Foster","cloud-download"),
				new Student(39,"Mary","Rodriguez","gears"),
				new Student(40,"David","Carter","picture-o"),
				new Student(41,"Johnny","Gray","quote-right"),
				new Student(42,"Charles","Walker","bolt"),
				new Student(43,"George","Hall","shopping-cart"),
				new Student(44,"Bobby","Thomas","plus-square"),
				new Student(45,"Karen","Green","star-o"),
				new Student(46,"Walter","Henderson","share-square"),
				new Student(47,"Andrea","Anderson","keyboard-o"),
				new Student(48,"Christina","Bell","mobile"),
				new Student(49,"Amanda","Evans","search"),
				new Student(50,"Ronald","Perez","crosshairs"),
				new Student(51,"Brenda","Murphy","toggle-left"),
				new Student(52,"Angela","Perry","refresh"),
				new Student(53,"Earl","Lopez","mail-reply"),
				new Student(54,"Lois","Campbell","barcode"),
				new Student(55,"Joe","Gonzalez","frown-o"),
				new Student(56,"Janice","Price","plane"),
				new Student(57,"Daniel","Sanchez","eye"),
				new Student(58,"Donald","Mitchell","meh-o"),
				new Student(59,"Frank","Cooper","ellipsis-v"),
				new Student(60,"Jane","Clark","spinner"),
				new Student(61,"Joyce","Phillips","sitemap"),
				new Student(62,"Brian","Richardson","tasks"),
				new Student(63,"Jennifer","Russell","credit-card"),
				new Student(64,"Howard","Hernandez","sort-down"),
				new Student(65,"Tammy","Peterson","cutlery"),
				new Student(66,"Stephen","Coleman","globe"),
				new Student(67,"Carl","Morris","bars"),
				new Student(68,"Gary","Ward","times-circle-o"),
				new Student(69,"Adam","Long","male"),
				new Student(70,"Russell","Brooks","group"),
				new Student(71,"Eugene","Wilson","superscript"),
				new Student(72,"Lori","Rivera","caret-square-o-up"),
				new Student(73,"Terry","Griffin","pencil-square"),
				new Student(74,"Anna","Young","plus-circle"),
				new Student(75,"Louis","Martin","eye-slash"),
				new Student(76,"Anne","Flores","info-circle"),
				new Student(77,"Cheryl","Sanders","rss-square"),
				new Student(78,"Michelle","Kelly","folder-o"),
				new Student(79,"Jesse","Bryant","check-circle-o"),
				new Student(80,"Randy","Alexander","volume-off"),
				new Student(81,"Billy","Parker","thumb-tack"),
				new Student(82,"Jeremy","Baker","gamepad"),
				new Student(83,"Teresa","Rogers","question-circle"),
				new Student(84,"Ryan","Cook","toggle-up"),
				new Student(85,"Jose","Collins","bookmark-o"),
				new Student(86,"Patricia","Moore","umbrella"),
				new Student(87,"Sandra","Turner","share-square-o"),
				new Student(88,"Joan","Garcia","unlock-alt"),
				new Student(89,"Beverly","Powell","sort-numeric-desc"),
				new Student(90,"Nicole","Diaz","caret-square-o-right"),
				new Student(91,"Rose","Adams","magic"),
				new Student(92,"Joshua","Scott","pencil-square-o"),
				new Student(93,"Philip","Roberts","eraser"),
				new Student(94,"Kathleen","Jenkins","hdd-o"),
				new Student(95,"Larry","Brown","puzzle-piece"),
				new Student(96,"Frances","Jackson","comment"),
				new Student(97,"Julia","Torres","thumbs-down"),
				new Student(98,"Kathryn","Johnson","external-link-square"),
				new Student(99,"Sarah","Miller","mobile-phone")
			});
	}
}
