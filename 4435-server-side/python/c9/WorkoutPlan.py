import datetime
class WorkoutPlan:
	def __init__(self, wname='', wtype='base run', pdist=0, ptime=0, surf='road', ctype='normal'):
		self.workout_name = wname
		self.workout_type = wtype
		self.planned_distance = pdist
		self.planned_time = ptime
		self.surface = surf
		self.course_type = ctype

	def planned_pace_mph(self):
		return self.planned_distance/(self.planned_time/3600)

	def planned_pace_seconds_per_mile(self):
		return self.planned_time/self.planned_distance

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
		return self.actual_distance/(self.actual_time/3600)

	def actual_pace_seconds_per_mile(self):
		return self.actual_time/self.actual_distance

	def deviation_from_plan(self):
		return (self.actual_distance-self.plan.planned_distance, self.actual_time-self.plan.planned_time)


p = WorkoutPlan('asd','asd', 5, 500, '53', 'wsdtg')
w = Workout(p, 4, 600)
print(w.deviation_from_plan())