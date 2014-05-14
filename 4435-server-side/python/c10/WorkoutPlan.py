import datetime
class Duration:
	def __init__(self, d = 0, **kwargs):
		self.hours = self.minutes = self.seconds = 0
		if 'hours' in kwargs:
			self.hours = kwargs['hours']
		if 'minutes' in kwargs:
			self.minutes = kwargs['minutes']
		if 'seconds' in kwargs:
			self.seconds = kwargs['seconds']
		self.duration = (self.hours*3600)+(self.minutes*60)+self.seconds + d

	def __str__(self):
		return str(datetime.timedelta(seconds=self.duration))

	def set_duration(self, d = 0, **kwargs):
		self.hours = self.minutes = self.seconds = 0
		if 'hours' in kwargs:
			self.hours = kwargs['hours']
		if 'minutes' in kwargs:
			self.minutes = kwargs['minutes']
		if 'seconds' in kwargs:
			self.seconds = kwargs['seconds']
		self.duration = (self.hours*3600)+(self.minutes*60)+self.seconds + d

	def plus(self):
		return self.duration + 1

	def minus(self):
		return self.duration - 1

	def increase(self):
		set_duration(plus())
		return self.duration

	def decrease(self):
		set_duration(minus())
		return self.duration

class WorkoutPlan:
	def __init__(self, wname='', wtype='base run', pdist=0, ptime=0, surf='road', ctype='normal'):
		self.workout_name = wname
		self.workout_type = wtype
		self.planned_distance = pdist
		if ptime.duration != None:
			self.planned_time = ptime
		else:
			self.planned_time = Duration(ptime)
		self.surface = surf
		self.course_type = ctype

	def planned_pace_mph(self):
		return self.planned_distance/(self.planned_time.duration/3600)

	def planned_pace_seconds_per_mile(self):
		return self.planned_time.duration/self.planned_distance

	@staticmethod
	def time_to_string(s):
		return str(datetime.timedelta(seconds=s))

class Workout(WorkoutPlan):
	def __init__(self, plan, adist, atime):
		super().__init__(plan.workout_name, plan.workout_type, plan.planned_distance, plan.planned_time, plan.surface, plan.course_type)
		self.plan = plan
		self.actual_distance = adist
		self.actual_time = atime

	def actual_pace_mph(self):
		return self.actual_distance/(self.actual_time.duration/3600)

	def actual_pace_seconds_per_mile(self):
		return self.actual_time.duration/self.actual_distance

	def deviation_from_plan(self):
		return (self.actual_distance-self.plan.planned_distance, Duration(self.actual_time.duration-self.plan.planned_time.duration))


p = WorkoutPlan('asd','asd', 5, Duration(500), '53', 'wsdtg')
w = Workout(p, 4, Duration(600))
print(w.deviation_from_plan())