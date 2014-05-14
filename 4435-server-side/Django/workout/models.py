from django.db import models
from profiles.models import CoachingUser
from django.core.urlresolvers import reverse
import re

class WorkoutType(models.Model):
    name = models.CharField(max_length=40)
    description = models.CharField(max_length=200, blank=True, null=True)
    def __str__(self):
        return self.name
    def isrun(self):
        run = re.compile(r'Run')
        running = re.compile(r'Running')
        return run.search(self.name) and not running.search(self.name)

class RunningSurface(models.Model):
    name = models.CharField(max_length=40)
    def __str__(self):
        return self.name

class CourseType(models.Model):
    name = models.CharField(max_length=40)
    description = models.CharField(max_length=200, blank=True, null=True)
    def __str__(self):
        return self.name

class WorkoutPlan(models.Model):
    name = models.CharField(max_length=40, blank=True, null=True)
    date = models.DateField(blank=True, null=True)
    type = models.ForeignKey(WorkoutType)
    surface = models.ForeignKey(RunningSurface)
    course_type = models.ForeignKey(CourseType)
    distance = models.FloatField(blank=True, null=True, default=0)
    time = models.FloatField(blank=True, null=True, default=0)
    warmup_instructions = models.CharField(max_length=200, blank=True, null=True)
    core_workout_instructions = models.CharField(max_length=200, blank=True, null=True)
    cooldown_instructions = models.CharField(max_length=200, blank=True, null=True)
    post_run_instructions = models.CharField(max_length=200, blank=True, null=True)
    target_hr = models.IntegerField(blank=True, null=True, default=0)
    target_difficulty = models.IntegerField(blank=True, null=True, default=0)
    comments = models.CharField(max_length=200, blank=True, null=True)

    def __str__(self):
        return self.name

    def get_absolute_url(self):
        return reverse('workoutplandetail', kwargs={'pk': self.pk})

class Workout(models.Model):
    name = models.CharField(max_length=40, blank=True, null=True)
    workout_plan = models.ForeignKey(WorkoutPlan)
    runner = models.ForeignKey(CoachingUser, null = True)
    date_time = models.DateTimeField()
    type = models.ForeignKey(WorkoutType)
    surface = models.ForeignKey(RunningSurface)
    course_type = models.ForeignKey(CourseType)
    distance = models.FloatField(blank=True, null=True, default=0)
    time = models.FloatField(blank=True, null=True, default=0)
    average_hr = models.IntegerField(blank=True, null=True, default=0)
    max_hr = models.IntegerField(blank=True, null=True, default=0)
    difficulty = models.IntegerField(blank=True, null=True, default=0)
    comments = models.CharField(max_length=200, blank=True, null=True)

    def __str__(self):
        return self.name

    def get_absolute_url(self):
        return reverse('workoutdetail', kwargs={'pk': self.pk})
