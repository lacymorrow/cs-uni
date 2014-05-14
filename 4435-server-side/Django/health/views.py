from django.shortcuts import render
from django.views.generic import ListView, CreateView
from django.contrib.auth.decorators import login_required

from health.models import Weight

class WeightList(ListView):
    template_name = 'health/weight_list.html'
    context_object_name = 'weight_list'
    @login_required
    def get_queryset(self):
    	if self.request.user.is_authenticated():
    	    # Do something for logged-in users.
    	    return Weight.objects.order_by('-date')[:7]
    	else:
    	    # Do something for anonymous users.
    	    return None

class WeightAdd(CreateView):
    model=Weight
    fields = ['date', 'weight', 'comment']
    template_name = 'health/weight_add.html'
