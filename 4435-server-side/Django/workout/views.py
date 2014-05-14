from datetime import timedelta
from django.views import generic
from django.utils import timezone
from django.shortcuts import render
from profiles.views import LoggedInMixin
from workout.models import Workout, WorkoutPlan
from django.contrib.auth.decorators import login_required
from django.views.generic.edit import CreateView, UpdateView, DeleteView


class WorkoutIndexView(generic.ListView): #!(LoggedInMixin, generic.ListView):
    template_name = 'workout/workoutindex.html'
    context_object_name = 'workout_list'
    #!@login_required
    def get_queryset(self):
        """Return the list of workouts"""
        if self.request.user.is_authenticated():
            # Do something for logged-in users.
            return Workout.objects.order_by('date_time')
        else:
            # Do something for anonymous users.
            return None

class WorkoutDetailView(generic.DetailView):
    model = Workout
    template_name = 'workout/workoutdetail.html'

class WorkoutCreate(CreateView):
    model = Workout
    fields = ['name', 'workout_plan', 'date_time', 'type', 'surface', 'course_type',
              'distance', 'time', 'average_hr', 'max_hr', 'difficulty',
              'comments']
    template_name = 'workout/workout_add.html'
    def form_valid(self, form):
        form.instance.user = self.request.user
        return super(WorkoutCreate, self).form_valid(form)

class WorkoutPlanIndexView(generic.ListView): #!(LoggedInMixin, generic.ListView):
    template_name = 'workout/workoutplanindex.html'
    context_object_name = 'workout_plan_list'
    #!@login_required
    def get_queryset(self):
        """Return the list of workout plans"""
        if self.request.user.is_authenticated():
            # Do something for logged-in users.
            return WorkoutPlan.objects.order_by('date')
        else:
            # Do something for anonymous users.
            return None

class WorkoutPlanDetailView(generic.DetailView):
    model = WorkoutPlan
    template_name = 'workout/workoutplandetail.html'

class WorkoutPlanCreate(CreateView):
    model = WorkoutPlan
    fields = ['name', 'date', 'type', 'surface', 'course_type', 
              'distance', 'time', 'warmup_instructions', 'core_workout_instructions',
              'cooldown_instructions', 'post_run_instructions', 'target_hr',
              'target_difficulty', 'comments']
    def form_valid(self, form):
        form.instance.user = self.request.user
        return super(WorkoutPlanCreate, self).form_valid(form)

def analysis(request):
    seven_days_ago = timezone.now().date() - timedelta(days=7)
    workout_list = Workout.objects.filter(date_time__gte=seven_days_ago).order_by('date_time')
    analysis = compute_analysis_data(workout_list)
    context = {'workout_list': workout_list, 'analysis' : analysis}
    return render(request, 'workout/analysis.html', context)

def compute_analysis_data(wl):
    a = {}
    a['runningworkouts'] = 0
    a['crosstrainingworkouts'] = 0
    a['coreworkouts'] = 0
    a['totalworkouttime'] = 0
    a['totalmiles'] = 0
    a['totalrunningtime'] = 0
    a['longestrun'] = 0
    for w in wl:
        a['totalworkouttime'] += w.time
        if w.type.isrun():
            a['runningworkouts'] += 1
            a['totalmiles'] += w.distance
            a['totalrunningtime'] += w.time
            if w.distance > a['longestrun']:
                a['longestrun'] = w.distance
        elif w.name == 'Core Strength':
            a['coreworkouts'] += 1
        else:
            a['crosstrainingworkouts'] += 1
    a['averagepace'] = a['totalrunningtime'] / a['totalmiles']
    return a
