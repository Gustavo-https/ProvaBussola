import { Component, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AppService } from './app.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnDestroy {
  userForm: any;
  constructor(private appService: AppService) {}

  title = 'angular-nodejs-example';

  userForm = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  users: any[] = [];
  userCount = 0;

  destroy$: Subject<boolean> = new Subject<boolean>();

  onSubmit() {
    this.appService
      .addUser(this.userForm.value, this.userCount + 1)
      .pipe(takeUntil(this.destroy$))
      .subscribe((data: any) => {
        console.log('message::::', data);
        this.userCount = this.userCount + 1;
        console.log(this.userCount);
        this.userForm.reset();
      });
  }

  getAllUsers() {
    this.appService
      .getUsers()
      .pipe(takeUntil(this.destroy$))
      .subscribe((users: any[]) => {
        this.userCount = users.length;
        this.users = users;
      });
  }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }

  ngOnInit() {
    this.getAllUsers();
  }
}
