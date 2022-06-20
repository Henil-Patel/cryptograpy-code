class LFSR:
	
	def __init__(self, initialization_vector: tuple, feedback_paths: tuple):
		self.seed = initialization_vector
		self.taps = feedback_paths
		self.cache = list()
		self.stream = str()
		
	def run(self):
		vec = self.seed
		self.cache.append(vec)
		self.stream = self.stream + str(vec[-1])
		clk = 0 
		print(f"\ninit -> clk: {clk} | {vec}")
		while True:
			tap_out = self._xor(vec)
			vec = (tap_out,) + vec[:-1]
			self.stream = self.stream + str(vec[-1])
			
			if vec in self.cache:
				break
			
			clk = clk + 1
			
			print(f"        clk: {clk} | {vec}")
			self.cache.append(vec)
			
	def _xor(self, vec):
		accumulator = 0
		for i in taps:
			dex = -(i + 1)
			accumulator = accumulator ^ vec[dex]
		
		return accumulator
	

if __name__ == "__main__":
	init_vec = (1,0,0)
	taps = (0, 2)
	lfsr = LFSR(init_vec, taps)
	lfsr.run()
	print("\nThe output stream is: {}" .format(lfsr.stream))
			
