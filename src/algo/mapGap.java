package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mapGap {

	public static void main(String[] args) {
		mapGap obj = new mapGap();
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				46158044, 9306314, 51157916, 93803496, 20512678, 55668109, 488932, 24018019, 91386538, 68676911, 92581441, 66802896, 10401330, 57053542, 42836847, 24523157, 50084224, 16223673, 18392448, 61771874, 75040277, 30393366, 1248593, 71015899, 20545868, 75781058, 2819173, 37183571, 94307760, 88949450, 9352766, 26990547, 4035684, 57106547, 62393125, 74101466, 87693129, 84620455, 98589753, 8374427, 59030017, 69501866, 47507712, 84139250, 97401195, 32307123, 41600232, 52669409, 61249959, 88263327, 3194185, 10842291, 37741683, 14638221, 61808847, 86673222, 12380549, 39609235, 98726824, 81436765, 48701855, 42166094, 88595721, 11566537, 63715832, 21604701, 83321269, 34496410, 48653819, 77422556, 51748960, 83040347, 12893783, 57429375, 13500426, 49447417, 50826659, 22709813, 33096541, 55283208, 31924546, 54079534, 38900717, 94495657, 6472104, 47947703, 50659890, 33719501, 57117161, 20478224, 77975153, 52822862, 13155282, 6481416, 67356400, 36491447, 4084060, 5884644, 91621319, 43488994, 71554661, 41611278, 28547265, 26692589, 82826028, 72214268, 98604736, 60193708, 95417547, 73177938, 50713342, 6283439, 79043764, 52027740, 17648022, 33730552, 42851318, 13232185, 95479426, 70580777, 24710823, 48306195, 31248704, 24224431, 99173104, 31216940, 66551773, 94516629, 67345352, 62715266, 8776225, 18603704, 7611906 
		});
		System.out.println(obj.maximumGap(list));
	}


	public int maximumGap(final List<Integer> A) {

		ArrayList<Value> list = new ArrayList<>();

		for(int i =0; i< A.size(); i++){
			list.add(new Value(A.get(i), i));
		}

		Collections.sort(list, new Comparator<Value>() {

			@Override
			public int compare(Value o1, Value o2) {
				// TODO Auto-generated method stub
				return o1.value >= o2.value ? 1 : -1;
			}
		});

		Utilities.printArrayList(list);


		int[] maxGapArr = new int[list.size()]; 

		int max = Integer.MIN_VALUE;
		for(int i = list.size()-1; i>0 ; i--) {
			Value value = list.get(i);
			max = Math.max(max, value.index);
			maxGapArr[i]=max;
		}

		int maxGap =0;

		for(int i =0; i<maxGapArr.length;i++) {
			int tempGap= maxGapArr[i]- list.get(i).index;
			if(tempGap> maxGap) {
				maxGap= tempGap;
			}
		}


		return maxGap;


	}
}

class Value {
	int value;
	int index;

	Value(int value, int index){
		this.value = value;
		this.index = index;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+value + " "+ index;
	}

}

