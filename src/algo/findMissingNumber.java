package algo;

import java.util.ArrayList;

public class findMissingNumber {
	
	public static void main(String[] args) {

		

		ArrayList<Integer> t = Utilities.toList(new Integer[] {
				759, 614, 396, 682, 892, 813, 522, 970, 73, 533, 513, 965, 822, 949, 471, 840, 974, 719, 423, 216, 197, 758, 709, 832, 632, 187, 432, 622, 765, 168, 333, 230, 772, 240, 170, 953, 699, 362, 473, 175, 95, 321, 739, 507, 890, 309, 901, 672, 791, 404, 114, 445, 612, 850, 346, 738, 577, 14, 79, 518, 19, 260, 285, 134, 460, 647, 425, 784, 874, 167, 665, 48, 567, 119, 741, 883, 919, 401, 823, 124, 377, 437, 26, 11, 389, 611, 464, 830, 786, 68, 584, 549, 956, 356, 757, 680, 373, 366, 889, 391, 360, 142, 655, 936, 934, 534, 25, 470, 834, 337, 869, 311, 450, 272, 352, 678, 984, 90, 616, 891, 698, 61, 568, 684, 163, 804, 283, 249, 1000, 453, 726, 630, 608, 406, 103, 410, 821, 89, 774, 494, 472, 653, 228, 176, 182, 334, 202, 881, 128, 331, 863, 276, 635, 320, 972, 916, 777, 86, 770, 923, 49, 591, 252, 814, 870, 771, 2, 734, 56, 967, 245, 214, 233, 592, 865, 338, 177, 856, 914, 997, 723, 156, 87, 23, 502, 756, 523, 305, 763, 894, 886, 172, 827, 18, 550, 365, 310, 220, 844, 587, 102, 839, 300, 63, 733, 429, 34, 599, 661, 853, 808, 781, 986, 350, -3, 563, 851, 722, 489, 117, 275, 688, 924, 574, 798, 740, 439, 476, 152, 171, 20, 426, 499, 267, 273, 270, 369, 913, 364, 583, 864, 593, 138, 831, 937, 297, 294, 44, 33, 745, 837, 885, 81, 897, 495, 277, 150, 107, 282, 436, 697, 660, 520, 339, 83, 620, 565, 800, 468, 643, 13, 454, 589, 279, 836, 618, 60, 862, 876, 561, 108, 728, 82, 544, 768, 166, 628, 76, -5, -1, 178, 348, 7, 191, 482, 968, 441, 394, 755, 3, 508, 548, 909, 58, 918, 524, 702, 716, 858, 789, 143, 859, 696, 717, 97, 646, 824, 998, 40, 383, 845, 900, 715, 106, 227, 767, 963, 556, 357, 975, 77, 92, 415, 564, 284, 349, 920, 957, 36, 386, 313, 145, 705, 659, 262, 636, 427, 70, 253, 497, 675, 829, 947, 323, 296, 157, 600, 809, 748, 147, 221, 526, 992, 778, 347, 422, 376, 787, 983, 85, 210, 222, 345, 302, 397, 329, 588, 888, 833, 964, 500, 440, 626, 552, 503, 663, 944, 737, 259, 64, 71, 424, 641, 532, 855, 990, 805, 570, 860, 773, 116, 929, 941, 57, 312, 677, 912, 154, 96, 10, 887, 39, 243, 379, 754, 952, 931, 62, 299, 215, 578, 236, 75, 538, 668, 976, 194, 211, 72, 928, 242, 420, 693, 478, 180, 749, 945, 637, 15, 700, 802, 419, 98, 882, 525, 139, 408, 229, 467, 125, 799, 590, 720, 656, 736, 132, 451, 37, 355, 372, 483, 123, 446, 490, 232, 664, 286, 867, 902, 204, 989, 871, 5, 690, 828, 922, 239, 761, 707, 935, 536, 905, 586, 22, 735, 131, 551, 818, 674, 691, 455, 933, 293, 268, 456, 714, 200, 515, 462, 21, 265, 126, 207, 493, 213, 269, 692, 519, 458, 234, 179, 760, 378, 223, 996, 878, 185, 766, 981, 875, 940, 314, 457, 112, 999, 604, 101, 676, 977, 954, 287, 751, 797, 617, 820, 428, 581, 541, 854, 662, 258, 395, 644, 543, 29, 595, 893, 435, 619, 217, 341, 769, 31, 184, 706, 146, 866, 810, 374, 585, 528, 238, 747, 847, 461, 109, 315, 752, 161, 746, 727, 475, 135, 562, 744, 274, 93, 411, 775, 325, 375, 811, 961, 358, 873, 251, 409, 151, 160, 30, 634, 278, 190, 225, 782, 52, 689, 843, 602, 289, 743, 100, 943, 780, 806, 788, 292, 88, 181, 80, 452, 627, 368, 433, 487, 596, 531, 381, 995, 370, 959, 195, 477, 291, 921, 962, 359, -4, 430, 601, 987, 537, 400, 994, 575, 342, 4, 504, 621, 120, 165, 209, 725, 750, 481, 546, 948, 28, 857, 326, 24, 244, 235, 803, 69, 43, 1, 673, 484, 753, 704, 99, 701, 186, 492, 443, 610, 255, 613, 955, 340, 597, 84, 606, 942, 667, 529, 915, 332, 173, 651, 517, 288, 776, 807, 666, 367, 9, 631, 731, 318, 226, 434, 206, 985, 982, 241, 480, 679, 683, 59, 65, 137, 42, 129, 465, 615, 598, 47, 133, 66, 910, 742, 407, 257, 792, 991, 94, 835, 650, 144, 361, 649, 363, 16, 174, 861, 6, 205, 979, 640, 657, 402, 469, 907, 0, 264, 447, 505, 12, 479, 290, 506, 50, 148, 762, 32, 51, 122, 926, 571, 849, 301, 155, 579, 387, 654, 559, 605, 153, 35, 939, 980, 509, 188, 790, 510, 557, 580, 399, 442, 371, 421, 501, 414, 838, 555, 558, 671, 78, 540, 281, 607, 685, 648, 298, 783, 514, 884, 485, 971, 231, 488, 271, 764, 208, 466, 713, 413, 162, 53, 474, 308, 958, 625, 46, 140, 385, 196, 718, 307, 105, 130, 247, 841, 303, 412, 545, 603, 547, 898, 686, 793, 261, 842, 8, 295, 993, 353, 393, 535, 904, 388, 669, 848, 710, 794, 110, 512, 899, 498, 966, 542, 703, 623, 380, 633, 343, 431, 946, 212, 263, 917, 694, 198, 879, 950, 930, 113, 91, 121, 67, 969, 317, 38, 224, 530, 250, 932, 183, 973, 553, 491, 785, 695, 896, 846, 670, 136, 825, 417, 572, 324, 911, 192, 681, 416, 104, 319, 392, 658, 304, 496, 960, 330, 351, 237, 405, 344, 527, 189, 895, 729, 199, 801, 629, 438, 486, 459, 382, 248, 27, 569, 708, 816, 815, 115, 449, 639, 111, 219, 978, 730, 336, 158, 880, 306, 812, 819, 164, 576, -2, 444, 872, 256, 54, 642, 418, 877, 403, 246, 41, 624, 906, 335, 796, 908, 539, 74, 927 });
		

		findMissingNumber obj = new findMissingNumber();
		System.out.println(obj.firstMissingPositive(t));
	}

	public int firstMissingPositive(ArrayList<Integer> A) {
		
		System.out.println(A.indexOf(1));
		System.out.println(A.size());

		for(int i =0; i< A.size() ; i++){
			int no = A.get(i);
			if(no <= 0){
				A.remove(i);
			}
		}
		
		System.out.println(A.indexOf(1));
		System.out.println(A.size());

		
		
		for(int i =0; i< A.size() ; i++) {
			int no = Math.abs(A.get(i));
			
			
			if(no <= A.size() && no > 0 && A.get(no-1) > 0 ) {
				A.set(no-1, -1 * A.get(no-1));
				
				if(no == 1) {
					System.out.println(A.get(no-1));
				}
			}
		}
		

		
		for(int  i =0; i < A.size() ; i++) {
			
			int no = A.get(i);
			
			if(no > 0) {
				return i+1;
			}
		}
		
		
		return A.size()+1;
	}



}