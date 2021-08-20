---
layout: page
title: OSDM Sandbox
permalink: /tools/sandbox/
---

## Aim

The aim of the **OSDM sandbox** is to provide implementing or interesting parties
access to a *working prototype* to study the behavior and semantics of the OSDM API.

The sandbox is kindly provided by [Sqills](https://www.sqills.com) and is open to *any party*
interested in implementing OSDM.

## Available Network and Services

Currently the **OSDM sandbox** implemented with *S3 Passengers* supports the following virtual routes and services:

- First Route:  *Amsterdam* - *Paris*

  The service simulated is a high speed IRT train where the products *admission with included reservation* as well as the ancillary services *luggage* and *bike* are available.

- Second Route:  *Amsterdam* - *Köln* - *Frankfurt (Main) Hbf* - *Basel SBB* - *Thun*

  The service simulated is a high speed train where the products *admission* as well as a *monthly pass* are available. Additionally a *bus ticket* to a commuting bus is available.

 - Third Route: *Basel SBB* - *Chur* - *Brig*

   The service simulated is a ICE train that travels from *Basel* to *Chur* with an optional seat reservation on the first leg. On the second leg there is a touristic train running with
   a included seat reservation as well as mandatory ancillaries such as 3 course menu.

If sensible, upon request Sqills will provide additional routes and services.

## Contact

All API activity via the OSDM API takes place with a so-called “agent”. Upon request, an agent
account can be set up for OSDM project partners and a welcome email message will distribute a
username and password combination which is required to obtain a OAuth2 JWT token with which the
actual OSDM calls can be performed on the API.

To register an account, please send an email including your name, role, company and a brief
explanation of your interest in OSDM to [sandbox-osdm@sqills.com](mailto:sandbox-osdm@sqills.com).

![Sqills](../images/logo/Sqills-logo.png)