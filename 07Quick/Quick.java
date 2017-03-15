public static int part(int [] data, int start, int end){
	Random r = new Random();
	int pivot = data[r.nextInt(data.length)];
	int hold = 0;
	for (int i = start; i < end - 1; i++){
		if(data[i] <= pivot){
			hold = data[start];
			data[start] = data[i];
			data[i] = hold;
		}
	}
	hold = data[start];
	data[start + 1] = data[end];
	data[end] = hold;
	return indexOf(pivot);
}
