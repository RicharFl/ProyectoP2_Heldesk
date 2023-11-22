import { TestBed } from '@angular/core/testing';

import { AgenteMesaGuard } from './agente-mesa.guard';

describe('AgenteMesaGuard', () => {
  let guard: AgenteMesaGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AgenteMesaGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
