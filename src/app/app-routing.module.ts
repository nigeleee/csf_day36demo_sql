import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home.component';
import { SubmissionComponent } from './component/submission.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'submission', component: SubmissionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
